$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AppiumLatest.feature");
formatter.feature({
  "line": 1,
  "name": "Create a recurring meeting using Native Android/iOS Calendar App.",
  "description": "",
  "id": "create-a-recurring-meeting-using-native-android/ios-calendar-app.",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Create a new recurring(3 days a week) meeting, and make sure it doesn\u0027t repeat on successive days",
  "description": "",
  "id": "create-a-recurring-meeting-using-native-android/ios-calendar-app.;create-a-new-recurring(3-days-a-week)-meeting,-and-make-sure-it-doesn\u0027t-repeat-on-successive-days",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "I have launched the Calendar App",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I want to set a meeting for \u003cday\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Meeting is not repeated on successive days",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I want to book a meeting with the title “Recurring-Team Catch Up”",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Set Meeting duration as \u003chours\u003e and \u003cminutes\u003e in the evening",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I invite \u003cnumberOfInvitees\u003e of people",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I save the meeting",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I Check if the meeting is created as expected",
  "keyword": "Then "
});
formatter.examples({
  "line": 14,
  "name": "",
  "description": "",
  "id": "create-a-recurring-meeting-using-native-android/ios-calendar-app.;create-a-new-recurring(3-days-a-week)-meeting,-and-make-sure-it-doesn\u0027t-repeat-on-successive-days;",
  "rows": [
    {
      "cells": [
        "day",
        "hours",
        "minutes",
        "numberOfInvitees"
      ],
      "line": 15,
      "id": "create-a-recurring-meeting-using-native-android/ios-calendar-app.;create-a-new-recurring(3-days-a-week)-meeting,-and-make-sure-it-doesn\u0027t-repeat-on-successive-days;;1"
    },
    {
      "cells": [
        "Monday",
        "1",
        "30",
        "2"
      ],
      "line": 16,
      "id": "create-a-recurring-meeting-using-native-android/ios-calendar-app.;create-a-new-recurring(3-days-a-week)-meeting,-and-make-sure-it-doesn\u0027t-repeat-on-successive-days;;2"
    },
    {
      "cells": [
        "Sunday",
        "1",
        "00",
        "1"
      ],
      "line": 17,
      "id": "create-a-recurring-meeting-using-native-android/ios-calendar-app.;create-a-new-recurring(3-days-a-week)-meeting,-and-make-sure-it-doesn\u0027t-repeat-on-successive-days;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6780049999,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Create a new recurring(3 days a week) meeting, and make sure it doesn\u0027t repeat on successive days",
  "description": "",
  "id": "create-a-recurring-meeting-using-native-android/ios-calendar-app.;create-a-new-recurring(3-days-a-week)-meeting,-and-make-sure-it-doesn\u0027t-repeat-on-successive-days;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "I have launched the Calendar App",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I want to set a meeting for Monday",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Meeting is not repeated on successive days",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I want to book a meeting with the title “Recurring-Team Catch Up”",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Set Meeting duration as 1 and 30 in the evening",
  "matchedColumns": [
    1,
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I invite 2 of people",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I save the meeting",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I Check if the meeting is created as expected",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.iHaveLaunchedTheCalendarApp()"
});
formatter.result({
  "duration": 8866659912,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Monday",
      "offset": 28
    }
  ],
  "location": "StepDefinition.itIsNotADay(String)"
});
formatter.result({
  "duration": 2316862,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.meetingIsNotRepeatedOnSuccessiveDays()"
});
formatter.result({
  "duration": 2389468885,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.iWantToBookAMeetingWithTheTitleRecurringTeamCatchUp()"
});
formatter.result({
  "duration": 592211116,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 24
    },
    {
      "val": "30",
      "offset": 30
    }
  ],
  "location": "StepDefinition.setMeetingDurationAsHoursAndMinutesInTheEvening(String,String)"
});
formatter.result({
  "duration": 19889423814,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 9
    }
  ],
  "location": "StepDefinition.iInviteNumberOfInviteesOfPeople(String)"
});
formatter.result({
  "duration": 3047950931,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.iSaveTheMeeting()"
});
formatter.result({
  "duration": 788218847,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.iCheckIfTheMeetingIsCreatedAsExpected()"
});
formatter.result({
  "duration": 4435525358,
  "status": "passed"
});
formatter.after({
  "duration": 3915648098,
  "status": "passed"
});
formatter.before({
  "duration": 5521440213,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Create a new recurring(3 days a week) meeting, and make sure it doesn\u0027t repeat on successive days",
  "description": "",
  "id": "create-a-recurring-meeting-using-native-android/ios-calendar-app.;create-a-new-recurring(3-days-a-week)-meeting,-and-make-sure-it-doesn\u0027t-repeat-on-successive-days;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "I have launched the Calendar App",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I want to set a meeting for Sunday",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Meeting is not repeated on successive days",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I want to book a meeting with the title “Recurring-Team Catch Up”",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Set Meeting duration as 1 and 00 in the evening",
  "matchedColumns": [
    1,
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I invite 1 of people",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I save the meeting",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I Check if the meeting is created as expected",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.iHaveLaunchedTheCalendarApp()"
});
formatter.result({
  "duration": 7072044589,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sunday",
      "offset": 28
    }
  ],
  "location": "StepDefinition.itIsNotADay(String)"
});
formatter.result({
  "duration": 120728,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.meetingIsNotRepeatedOnSuccessiveDays()"
});
formatter.result({
  "duration": 2206395371,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.iWantToBookAMeetingWithTheTitleRecurringTeamCatchUp()"
});
formatter.result({
  "duration": 570150008,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 24
    },
    {
      "val": "00",
      "offset": 30
    }
  ],
  "location": "StepDefinition.setMeetingDurationAsHoursAndMinutesInTheEvening(String,String)"
});
formatter.result({
  "duration": 18711076374,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 9
    }
  ],
  "location": "StepDefinition.iInviteNumberOfInviteesOfPeople(String)"
});
formatter.result({
  "duration": 1482247637,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.iSaveTheMeeting()"
});
formatter.result({
  "duration": 1888699886,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.iCheckIfTheMeetingIsCreatedAsExpected()"
});
formatter.result({
  "duration": 2414573622,
  "status": "passed"
});
formatter.after({
  "duration": 3817277521,
  "status": "passed"
});
});