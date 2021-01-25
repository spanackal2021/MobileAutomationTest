package com.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class IntroductionPage extends BasePage{

    private final String nextPageSection = "next page";
    private final String gotItButton = "Got it";

    public IntroductionPage(AppiumDriver driver) {
        super(driver);
    }

    public MobileElement getNextPageSection() {
        return getElement(nextPageSection);
    }

    public MobileElement getGotItButton() {
        return getElement(gotItButton);
    }

    public EventPage clickOnNextOnAllIntroductoryScreens() {
        getNextPageSection().click();
        getNextPageSection().click();
        getNextPageSection().click();
        getGotItButton().click();
        return getInstance(EventPage.class);
    }

}
