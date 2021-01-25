package com.utils;

import cucumber.api.Scenario;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;

import static com.utils.UtilConstants.getCurrentTimeStamp;

public class DriverUtils {

    public static void swipeRight(WebElement webElement, WebDriver driver){
        Dimension dimension = webElement.getSize();
        int anchor = webElement.getSize().getHeight()/2;

        double screenWidthStart = dimension.getWidth() * 0.8;
        int scrollStart = (int) screenWidthStart;

        double screenWidthEnd = dimension.getWidth() * 0.1;
        int scrollEnd = (int) screenWidthEnd;

        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(scrollStart, anchor))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(scrollEnd, anchor))
                .release().perform();
    }


    public static void takeScreenShot(Scenario scenario, WebDriver driver){
        String fileSeperator = System.getProperty("file.separator");
        String targetLocation = null;

        String screenshotsPath = System.getProperty("user.dir") + fileSeperator + "test-output" + fileSeperator
                + "screenshots";

        try {
            File file = new File(screenshotsPath);
            if (!file.exists()) {
                if (file.mkdirs()) {
                    System.out.println("Directory: " + file.getAbsolutePath() + " is created!");
                } else {
                    System.out.println("Failed to create directory: " + file.getAbsolutePath());
                }

            }
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            targetLocation = screenshotsPath + fileSeperator + scenario.getName() + getCurrentTimeStamp() + ".png";

            File targetFile = new File(targetLocation);
            System.out.println("Screen shot file location - " + screenshotFile.getAbsolutePath());
            System.out.println("Target File location - " + targetFile.getAbsolutePath());
            FileHandler.copy(screenshotFile, targetFile);

        } catch (FileNotFoundException e) {
            System.out.println("File not found exception occurred " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An exception occurred while taking screenshot " + e.getCause());
        }
    }


    public static void embedScreenshotToReport(Scenario scenario, WebDriver driver){
        try {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES.BYTES);
            scenario.embed(screenshot,"image/png");
        }
        catch (Exception e) {
            System.out.println("An exception occurred while embedding screenshot to report" + e.getCause());
        }

    }

}
