package com.driverFactory;

import io.appium.java_client.AppiumDriver;

public class DriverManager {

    private static ThreadLocal<AppiumDriver> Driver = new ThreadLocal<>();

    public static AppiumDriver getDriver() {
        return Driver.get();
    }

    public static void setDriver(AppiumDriver driver) {
        Driver.set(driver);
    }
}
