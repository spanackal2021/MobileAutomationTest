package com.steps;

import com.driverFactory.DriverFactory;
import com.driverFactory.DriverManager;
import com.pages.*;
import com.utils.AppiumSeverUtils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;

import static com.utils.UtilConstants.getAlternateDays;
import static com.utils.DriverUtils.*;

public class StepDefinition {

    Page page;
    EventPage eventPage;
    CalendarPage calendarPage;
    CalendarInformationPage calendarInformationPage;
    MeetingDetailsPage meetingDetailsPage;

    @Before
    public void setUp() throws MalformedURLException {
        AppiumSeverUtils.Start();
        AppiumDriver driver = DriverFactory.createInstance();
        DriverManager.setDriver(driver);
        page = new BasePage(DriverManager.getDriver());
    }


    @Given("I have launched the Calendar App")
    public void iHaveLaunchedTheCalendarApp() {
        eventPage = page.getInstance(IntroductionPage.class).clickOnNextOnAllIntroductoryScreens();
        calendarPage =eventPage.clickOnNewCalendarMeeting();
    }

    @When("^I want to set a meeting for (\\S+)$")
    public void itIsNotADay(String date) {
            getAlternateDays(date);
    }

    @And("Meeting is not repeated on successive days")
    public void meetingIsNotRepeatedOnSuccessiveDays() {
        calendarPage.assertThatMeetingIsNotScheduledToRepeatOnSuccessiveDays();
        
    }

    @Then("I want to book a meeting with the title “Recurring-Team Catch Up”")
    public void iWantToBookAMeetingWithTheTitleRecurringTeamCatchUp() {
        calendarPage.setMeetingTitleAsRecurringTeamCatchUp();
        
    }

    @And("Set Meeting duration as (\\S+) and (\\S+) in the evening$")
    public void setMeetingDurationAsHoursAndMinutesInTheEvening(String meetingHourDuration, String meetingMinuteDuration) {
        calendarPage.selectNonSuccessiveDaysToScheduleRecurringMeeting();
        calendarPage.setMeetingDuration(meetingHourDuration,meetingMinuteDuration);
        
    }

    @And("I invite (\\S+) of people$")
    public void iInviteNumberOfInviteesOfPeople(String number) {
        calendarPage.setInvite(number);

    }

    @And("I save the meeting")
    public void iSaveTheMeeting() {
        calendarInformationPage = calendarPage.saveMeeting();
    }

    @Then("I Check if the meeting is created as expected")
    public void iCheckIfTheMeetingIsCreatedAsExpected() {
        calendarInformationPage.clickOnJumpToTodayToViewTheListOfRecurringMeetings();
        calendarInformationPage.assertThatRecurringMeetingIsCreatedAndDisplayedUnderCalendarInformationView();
        meetingDetailsPage = calendarInformationPage.clickOnTheFirstRecurringMeetingDisplayedUnderCalendarInformationView();
        meetingDetailsPage.assertThatRecurringMeetingDetailsAreCorrectlyDisplayed();
    }

    private void deleteMeeting() {
        meetingDetailsPage.deleteRecurringMeetingCreated();
        calendarInformationPage.checkIfMeetingHasBeenDeleted();
    }

    @After
    public  void tearDown(Scenario scenario) {
        if(scenario.isFailed()){
            takeScreenShot(scenario,DriverManager.getDriver());
            embedScreenshotToReport(scenario, DriverManager.getDriver());
        }
        deleteMeeting();
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            driver.quit();
        }
        AppiumSeverUtils.Stop();
    }

}
