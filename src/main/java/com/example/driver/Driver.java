package com.example.driver;

import java.util.Objects;

import com.example.constants.FrameWorkConstants;
import com.example.enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.example.utils.PropertyUtils;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Driver class is responsible for invoking and closing the browsers. It is also responsible
 * for setting the driver variable to DriverManager which handles tht thread safety for the webdriver instance
 *
 * @param browser value will be passed from {@link com.tmb.tests.BaseTest}. values can be chrome and firefox
 * @see DriverManager
 * @see com.example.tests.BaseTest
 */

public final class Driver {

    /**
     * Private constructor to avoid external instantiation
     */
    private Driver() {

    }


    public static void initDriver(String browser) {
        if (Objects.isNull(DriverManager.getDriver())) {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                DriverManager.setDriver(new ChromeDriver()); //Ctrl+Shift+O
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                DriverManager.setDriver(new FirefoxDriver());
            }
            DriverManager.setDriver(DriverManager.getDriver());
            DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
