package com.example.tests;

import com.example.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

/**
 * Naming Convention:
 * class or Interface - SumClass
 * final or constant - HOMEPATH or HOME_PATH
 * method name - addTwoNumbers()
 * package name - example
 */

public final class LoginPageTests extends BaseTest {

    //Restrict from Creating Objects
    private LoginPageTests() {

    }

    @Test
    public void test1() {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
    }
}
