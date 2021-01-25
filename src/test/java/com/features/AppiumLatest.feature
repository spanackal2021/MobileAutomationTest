Feature: Create a recurring meeting using Native Android/iOS Calendar App.

  Scenario Outline: Create a new recurring(3 days a week) meeting, and make sure it doesn't repeat on successive days

    Given I have launched the Calendar App
    When I want to set a meeting for <day>
    And Meeting is not repeated on successive days
    Then I want to book a meeting with the title “Recurring-Team Catch Up”
    And Set Meeting duration as <hours> and <minutes> in the evening
    And I invite <numberOfInvitees> of people
    And I save the meeting
    Then I Check if the meeting is created as expected

    Examples:
      |day|hours|minutes|numberOfInvitees|
      |Monday|  1|    30|    2|
      |Sunday|  1|    00|    1|