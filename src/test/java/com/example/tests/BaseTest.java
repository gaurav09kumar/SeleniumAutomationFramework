package com.example.tests;

import com.example.driver.Driver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

public class BaseTest {

    protected BaseTest() {

    }

    /*
    while specifying the access modifiers
    private , protected, default then ---> public
     */
    @SuppressWarnings("unchecked")
    @BeforeMethod
    protected void setUp(Object[] data) {
        Map<String, String> map = (Map<String, String>) data[0];
        Driver.initDriver(map.get("browser"));
    }

    @AfterMethod
    protected void tearDown(ITestResult result) {
        Driver.quitDriver();
    }
}
