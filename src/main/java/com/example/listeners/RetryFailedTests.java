package com.example.listeners;

import com.example.enums.ConfigProperties;
import com.example.utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class RetryFailedTests implements IRetryAnalyzer {

    private int count = 0;
    private int retries = 1;

    @Override
    public boolean retry(ITestResult result) {
        boolean value = false;
        if (PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
            value = count < retries;
            count++;
        }
        return value;
    }
}
