package com.example.reports;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class ExtentManager {
    private ExtentManager() {

    }

    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

    public static ExtentTest getExtentTest() {
        return extTest.get();
    }

    static void setExtentTest(ExtentTest test) {
        extTest.set(test);
    }

    static void unload() {
        //call this method to clean up all your thread local variable
        extTest.remove();
    }
}
