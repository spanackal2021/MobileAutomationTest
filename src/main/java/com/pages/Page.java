package com.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

    public AppiumDriver driver;
    public WebDriverWait wait;


    public Page(AppiumDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public abstract MobileElement getElement(By locator);

    public abstract MobileElement getElement(String locator);

    public abstract void waitForElement(By locator);

    public abstract boolean isElementPresent(WebElement locator);

    public abstract void implicitlyWait();

    public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(AppiumDriver.class).newInstance(this.driver);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
