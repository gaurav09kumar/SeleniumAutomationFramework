package com.example.pages;

import com.example.driver.DriverManager;
import com.example.enums.WaitStrategy;
import com.example.factories.ExplicitWaitFactory;
import com.example.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy, String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
        element.click();
        try {
            ExtentLogger.pass(elementName + " is clicked", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
        element.sendKeys(value);
        try {
            ExtentLogger.pass(value + " is entered successfully in " + elementName, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }
}
