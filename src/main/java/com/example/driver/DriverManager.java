package com.example.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private DriverManager() {

    }

    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return dr.get();
    }

    public static void setDriver(WebDriver driverReference) {
        dr.set(driverReference);
    }

    //completely remove values from thread local -> make dr = null
    public static void unload() {
        dr.remove();
    }
}
