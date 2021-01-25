package com.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;

import static com.utils.UtilConstants.*;

public class CalendarInformationPage extends BasePage {

    private final String jumpToTodayButton = "Jump to Today";

    public CalendarInformationPage(AppiumDriver driver) {
        super(driver);
    }

    public MobileElement getJumpToTodayButton() {
        return getElement(jumpToTodayButton);
    }

    public void clickOnJumpToTodayToViewTheListOfRecurringMeetings() {
        getJumpToTodayButton().click();
    }

    public void assertThatRecurringMeetingIsCreatedAndDisplayedUnderCalendarInformationView() {
        if(calculatedDaysAndTime.get("meetingEndTime").charAt(0) == '0'){
            Assert.assertTrue(getElement(By.xpath(String.format("(//android.view.View[@content-desc=\"%s – %s:%s %s: %s\"])[1]",getMeetingStartTime(),calculatedDaysAndTime.get("meetingEndTime").split(":")[0].substring(1),calculatedDaysAndTime.get("meetingEndTime").split(":")[1].split(" ")[0],calculatedDaysAndTime.get("meetingEndTime").split(" ")[1].toUpperCase(),getMeetingTitle()))).isDisplayed());
        }
        else{
            Assert.assertTrue(getElement(By.xpath(String.format("(//android.view.View[@content-desc=\"%s – %s:%s %s: %s\"])[1]",getMeetingStartTime(),calculatedDaysAndTime.get("meetingEndTime").split(":")[0],calculatedDaysAndTime.get("meetingEndTime").split(":")[1].split(" ")[0],calculatedDaysAndTime.get("meetingEndTime").split(" ")[1].toUpperCase(),getMeetingTitle()))).isDisplayed());
        }

    }

    public MeetingDetailsPage clickOnTheFirstRecurringMeetingDisplayedUnderCalendarInformationView() {
        if(calculatedDaysAndTime.get("meetingEndTime").charAt(0) == '0'){
            getElement(By.xpath(String.format("(//android.view.View[@content-desc=\"%s – %s:%s %s: %s\"])[1]",getMeetingStartTime(),calculatedDaysAndTime.get("meetingEndTime").split(":")[0].substring(1),calculatedDaysAndTime.get("meetingEndTime").split(":")[1].split(" ")[0],calculatedDaysAndTime.get("meetingEndTime").split(" ")[1].toUpperCase(),getMeetingTitle()))).click();
        }
        else {
            getElement(By.xpath(String.format("(//android.view.View[@content-desc=\"%s – %s:%s %s: %s\"])[1]",getMeetingStartTime(),calculatedDaysAndTime.get("meetingEndTime").split(":")[0],calculatedDaysAndTime.get("meetingEndTime").split(":")[1].split(" ")[0],calculatedDaysAndTime.get("meetingEndTime").split(" ")[1].toUpperCase(),getMeetingTitle()))).click();
        }

        return getInstance(MeetingDetailsPage.class);
    }

    public void checkIfMeetingHasBeenDeleted(){
        wait.until((ExpectedCondition<Boolean>) d -> isElementPresent(getElement(jumpToTodayButton)));
    }


}
