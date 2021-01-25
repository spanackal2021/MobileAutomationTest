package com.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class EventPage extends BasePage{

    private final By plusButton = By.id("floating_action_button");
    private final By newEventButton = By.id("speed_dial_event_container");

    public EventPage(AppiumDriver driver) {
        super(driver);
    }

    public MobileElement getPlusButton() {
        return getElement(plusButton);
    }
    public MobileElement getNewEventButton() {
        return getElement(newEventButton);
    }

    public CalendarPage clickOnNewCalendarMeeting() {
        getPlusButton().click();
        getNewEventButton().click();
        return getInstance(CalendarPage.class);
    }

}
