package com.driverFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static com.utils.UtilConstants.*;

public class DriverFactory {

    public static AppiumDriver driver;

    synchronized public static AppiumDriver createInstance() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, getPlatformName());
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, getPlatformVersion());
        desiredCapabilities.setCapability("appPackage",getAppPackage());
        desiredCapabilities.setCapability("appActivity",getAppActivity());

        driver = new AndroidDriver<>(new URL(String.format("%s:%s/wd/hub",getBaseUrl(),getPort())),desiredCapabilities);

        return driver;
    }

}
