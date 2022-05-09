package com.example.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.example.constants.FrameWorkConstants;
import com.example.enums.CategoryType;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {
    private ExtentReport() {
    }

    private static ExtentReports extent;

    public static void initReports() {

        if (Objects.isNull(extent)) {

            //Setup Code of Extent Reports
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameWorkConstants.getExtentReportFilePath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("FrameWork Report");
            spark.config().setReportName("Training");
        }

    }

    public static void flushReports() {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        ExtentManager.unload(); //Thread local value will be completely removed
        try {
            Desktop.getDesktop().browse(new File(FrameWorkConstants.getExtentReportFilePath()).toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createTest(String testcasename) {
        ExtentManager.setExtentTest(extent.createTest(testcasename));
    }

    public static void addAuthors(String[] authors) {
        for (String temp : authors) {
            ExtentManager.getExtentTest().assignAuthor(temp);
        }
    }

    public static void addCategories(CategoryType[] categories) {
        for (CategoryType temp : categories) {
            ExtentManager.getExtentTest().assignCategory(temp.toString());
        }
    }

}
