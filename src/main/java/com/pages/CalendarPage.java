package com.pages;

import com.driverFactory.DriverManager;
import com.github.javafaker.Faker;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import org.openqa.selenium.*;
import org.testng.Assert;

import static com.utils.UtilConstants.*;
import static com.utils.DriverUtils.swipeRight;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class CalendarPage extends BasePage {

    private final By meetingInviteSubjectTextBox = By.id("input");
    private final By meetingDefaultStartDateSection = By.id("start_date");
    private final By calendarPanel = By.id("android:id/parentPanel");
    private final By okButton = By.xpath("//*[@text='OK']");
    private final By startTimeSection = By.id("start_time");
    private final String keyBoardSection = "Switch to text input mode for the time input.";
    private final By hourSection = By.id("android:id/input_hour");
    private final By minuteSection = By.id("android:id/input_minute");
    private final By amPmSpinner = By.id("android:id/am_pm_spinner");
    private final By startTimePmDropdownElement = By.xpath("//*[@text='PM']");
    private final By endTimeSection = By.id("end_time");
    private final By moreOptionsSection = By.id("more_options");
    private final By doesNotRepeatSection = By.xpath("//*[@text='Does not repeat']");
    private final By customSection = By.xpath("//*[@text='Custom…']");
    private final By doneButton = By.id("done");
    private final By invitationTextBox = By.id("guest_input");
    private final By saveButton = By.id("save");

    public CalendarPage(AppiumDriver driver) {
        super(driver);
    }

    public MobileElement getMeetingInviteSubjectTextBox() {
        return getElement(meetingInviteSubjectTextBox);
    }

    public MobileElement getMeetingDefaultStartDateSection() {
        return getElement(meetingDefaultStartDateSection);
    }

    public MobileElement getCalendarPanel() {
        return getElement(calendarPanel);
    }

    public MobileElement getOkButton() {
        return getElement(okButton);
    }

    public MobileElement getStartTimeSection() {
        return getElement(startTimeSection);
    }

    public MobileElement getKeyBoardSection() {
        return getElement(keyBoardSection);
    }

    public MobileElement getHourSection() {
        return getElement(hourSection);
    }

    public MobileElement getMinuteSection() {
        return getElement(minuteSection);
    }

    public MobileElement getAmPmSpinner() {
        return getElement(amPmSpinner);
    }

    public MobileElement getStartTimePmDropdownElement() { return getElement(startTimePmDropdownElement); }

    public MobileElement getEndTimeSection() {
        return getElement(endTimeSection);
    }

    public MobileElement getMoreOptionsSection() {
        return getElement(moreOptionsSection);
    }

    public MobileElement getDoesNotRepeatSection() {
        return getElement(doesNotRepeatSection);
    }

    public MobileElement getCustomSection() {
        return getElement(customSection);
    }

    public MobileElement getDoneButton() {
        return getElement(doneButton);
    }

    public MobileElement getInvitationTextBox() {
        return getElement(invitationTextBox);
    }

    public MobileElement getSaveButton() {
        return getElement(saveButton);
    }


    public void assertThatMeetingIsNotScheduledToRepeatOnSuccessiveDays(){
        getMoreOptionsSection().click();
        Assert.assertTrue(getDoesNotRepeatSection().isDisplayed());
    }

    public void selectNonSuccessiveDaysToScheduleRecurringMeeting(){
        getDoesNotRepeatSection().click();
        getCustomSection().click();
        if(calculatedDaysAndTime.get("firstDay").contentEquals(calculatedDaysAndTime.get("currentDay"))){
            getElement(By.xpath(String.format("//*[@text='%s']",calculatedDaysAndTime.get("secondDay").substring(0,3)))).click();
            getElement(By.xpath(String.format("//*[@text='%s']",calculatedDaysAndTime.get("thirdDay").substring(0,3)))).click();
        }
        else{
            getElement(By.xpath(String.format("//*[@text='%s']",calculatedDaysAndTime.get("currentDay").substring(0,3)))).click();
            getElement(By.xpath(String.format("//*[@text='%s']",calculatedDaysAndTime.get("firstDay").substring(0,3)))).click();
            getElement(By.xpath(String.format("//*[@text='%s']",calculatedDaysAndTime.get("secondDay").substring(0,3)))).click();
            getElement(By.xpath(String.format("//*[@text='%s']",calculatedDaysAndTime.get("thirdDay").substring(0,3)))).click();
        }

        getDoneButton().click();
    }


    public void setMeetingTitleAsRecurringTeamCatchUp(){
        getMeetingInviteSubjectTextBox().sendKeys(getMeetingTitle());

    }

    public void setInvite(String number){
        for (int i=0; i < Integer.parseInt(number); i++) {
            TouchAction touch = new TouchAction((DriverManager.getDriver()));
            Faker faker = new Faker();
            touch.tap(TapOptions.tapOptions().withElement(element(getInvitationTextBox()))).perform();
            DriverManager.getDriver().getKeyboard().sendKeys(faker.internet().emailAddress());
            DriverManager.getDriver().getKeyboard().pressKey(Keys.SPACE);
        }
            DriverManager.getDriver().getKeyboard().pressKey(Keys.ENTER);
    }

    public void setMeetingDuration(String meetingHourDuration, String meetingMinuteDuration){
        getMeetingDefaultStartDateSection().click();
        if(calculatedMonths.get("currentMonth").equals(calculatedMonths.get("firstDayMonth"))){
            getElement(getStartDay()).click();
        }

        else{
            swipeRight(getCalendarPanel(),DriverManager.getDriver());
            getElement(getStartDay()).click();
        }
        getOkButton().click();
        getStartTimeSection().click();
        getKeyBoardSection().click();
        getHourSection().clear();
        getHourSection().sendKeys(getMeetingStartTime().split(":")[0]);
        getMinuteSection().clear();
        getMinuteSection().sendKeys(getMeetingStartTime().split(":")[1]);
        getAmPmSpinner().click();
        getStartTimePmDropdownElement().click();
        getOkButton().click();
        getEndTimeSection().click();
        getKeyBoardSection().click();
        getHourSection().clear();
        getHourSection().sendKeys(getEndTime(meetingHourDuration,meetingMinuteDuration).split(" ")[0].split(":")[0]);
        getMinuteSection().clear();
        getMinuteSection().sendKeys(getEndTime(meetingHourDuration,meetingMinuteDuration).split(" ")[0].split(":")[1]);
        getOkButton().click();
    }



    public CalendarInformationPage saveMeeting() {
        getSaveButton().click();
        return getInstance(CalendarInformationPage.class);

    }

}
