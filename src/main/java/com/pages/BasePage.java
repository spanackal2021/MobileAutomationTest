package com.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;

public class BasePage extends Page{

    public BasePage(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public MobileElement getElement(By locator) {
        try{
            waitForElement(locator);
            return (MobileElement) driver.findElement(locator);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public MobileElement getElement(String locator) {
        try{
            implicitlyWait();
            return (MobileElement) driver.findElementByAccessibilityId(locator);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void waitForElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    @Override
    public boolean isElementPresent(WebElement el){
        try{
            el.isDisplayed();
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    @Override
    public void implicitlyWait() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
