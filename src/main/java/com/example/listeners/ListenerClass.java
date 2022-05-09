package com.example.listeners;

import com.example.annotations.FrameworkAnnotation;
import com.example.reports.ExtentLogger;
import com.example.reports.ExtentReport;
import org.testng.*;

import java.io.IOException;
import java.util.Arrays;

public class ListenerClass implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        //we can get method name directly without depending on USER
        ExtentReport.createTest(result.getMethod().getDescription());
        ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod()
                .getMethod().getAnnotation(FrameworkAnnotation.class).author());
        ExtentReport.addCategories(result.getMethod().getConstructorOrMethod()
                .getMethod().getAnnotation(FrameworkAnnotation.class).category());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //When the test case is failed then take screenshot
        ExtentLogger.fail(result.getMethod().getMethodName() + " is failed", true);
        ExtentLogger.fail(result.getThrowable().toString());
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        /**
         * For now, we are not using this
         *
         *
         */
    }

    @Override
    public void onStart(ITestContext context) {
        /**
         * For now, we are not using this
         *
         *
         */
    }

    @Override
    public void onFinish(ITestContext context) {
        /**
         * We are having just one test in our suite. So we don't have any special implementation as of now
         *
         */
    }
}
