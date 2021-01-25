package com.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.utils.UtilConstants.*;

public class MeetingDetailsPage extends BasePage{

    private final By meetingTitle = By.id("title");
    private final By meetingDurationText = By.id("first_line_text");
    private final By meetingRecurrenceText = By.id("second_line_text");
    private final String moreOptionsHamburgerIcon = "More options";
    private final By deleteSection = By.id("android:id/title");
    private final By thisAndFollowingEventsSection = By.xpath("//*[@text='This and following events']");
    private final By deleteConfirmationSection = By.id("android:id/button1");

    public MeetingDetailsPage(AppiumDriver driver) {
        super(driver);
    }

    public MobileElement getMeetingTitle() {
        return getElement(meetingTitle);
    }

    public MobileElement getMeetingDurationText() {
        return getElement(meetingDurationText);
    }

    public MobileElement getMeetingRecurrenceText() {
        return getElement(meetingRecurrenceText);
    }

    public MobileElement getMoreOptionsHamburgerIcon() {
        return getElement(moreOptionsHamburgerIcon);
    }

    public MobileElement getDeleteSection() {
        return getElement(deleteSection);
    }

    public MobileElement getThisAndFollowingEventsSection() {
        return getElement(thisAndFollowingEventsSection);
    }

    public MobileElement getDeleteConfirmationSection() {
        return getElement(deleteConfirmationSection);
    }

    public void assertThatRecurringMeetingDetailsAreCorrectlyDisplayed(){
        Assert.assertEquals(getMeetingTitle().getText(),"Recurring-Team Catch Up");
        if(calculatedDaysAndTime.get("meetingEndTime").charAt(0) == '0'){
            Assert.assertTrue(getMeetingDurationText().getText().contains((String.format("%s – %s:%s %s",getMeetingStartTime().split(" ")[0],calculatedDaysAndTime.get("meetingEndTime").split(":")[0].substring(1),calculatedDaysAndTime.get("meetingEndTime").split(":")[1].split(" ")[0],calculatedDaysAndTime.get("meetingEndTime").split(" ")[1].toUpperCase()))));
        }
        else {
            Assert.assertTrue(getMeetingDurationText().getText().contains((String.format("%s – %s:%s %s",getMeetingStartTime().split(" ")[0],calculatedDaysAndTime.get("meetingEndTime").split(":")[0],calculatedDaysAndTime.get("meetingEndTime").split(":")[1].split(" ")[0],calculatedDaysAndTime.get("meetingEndTime").split(" ")[1].toUpperCase()))));
        }
        Assert.assertTrue(getMeetingRecurrenceText().getText().contains("Repeats weekly on"));
        Assert.assertEquals(getMeetingRecurrenceText().getText().split(",").length,3);
    }


    public CalendarInformationPage deleteRecurringMeetingCreated() {
        getMoreOptionsHamburgerIcon().click();
        getDeleteSection().click();
        getThisAndFollowingEventsSection().click();
        getDeleteConfirmationSection().click();
        return getInstance(CalendarInformationPage.class);
    }

}
