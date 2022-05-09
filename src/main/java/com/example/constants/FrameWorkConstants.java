package com.example.constants;

import com.example.enums.ConfigProperties;
import com.example.utils.PropertyUtils;


public final class FrameWorkConstants {

    //restrict from creating Objects of FrameWorkConstants class
    private FrameWorkConstants() {

    }

    private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CHROMEDRIVERPATH = RESOURCESPATH + "/executables/chromedriver.exe";
    private static final String GECKODRIVERPATH = RESOURCESPATH + "/executables/geckodriver.exe";
    private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/config.properties";
    private static final String EXCELPATH = RESOURCESPATH + "/excel/testdata.xlsx";
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output/";
    private static String extentReportFilePath = "";
    private static final String RUNMANGERSHEET = "RUNMANAGER";
    private static final String ITERATIONDATASHEET = "DATA";

    public static String getIterationdatasheett() {
        return ITERATIONDATASHEET;
    }

    public static String getRunmangerDatasheet() {
        return RUNMANGERSHEET;
    }

    public static String getExtentReportFilePath() {
        if (extentReportFilePath.isEmpty()) {
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }

    private static String createReportPath() {
        if (PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
            return EXTENTREPORTFOLDERPATH + System.currentTimeMillis() + "/index.html";
        } else {
            System.out.println(EXTENTREPORTFOLDERPATH + "/index.html");
            return EXTENTREPORTFOLDERPATH + "/index.html";
        }
    }

    public static String getExcelpath() {
        return EXCELPATH;
    }

    private static final int EXPLICITWAIT = 10;

    public static String getConfigfilepath() {
        return CONFIGFILEPATH;
    }

    public static String getChromeDriverPath() {
        return CHROMEDRIVERPATH;
    }

    public static String getGeckoDriverPath() {
        return GECKODRIVERPATH;
    }

    public static int getExplicitWait() {
        return EXPLICITWAIT;
    }

}
