## Description:
Mobile Test Automation Suite for Sending Meeting Invite using Google Calendar App on Android Emulator

## Key Features:
1. End to End Tests to schedule a meeting invite based on user parameters such as day , meeting duration and number of invitees using Google Calendar App on Android Emulator
1. Based on the parameters provided by the user, for example if day is given as Monday , the next Monday in the week is set as the start day of the meeting to be scheduled and the time duration and number of invitees are set accordingly  based on the user parameters for executing the tests.
1. Screenshot Capture in case of test failures(can be accessed at test-output/screenshots Directory)
1. Screenshot Capture in case of test failures is also captured and embedded in the cucumber reports.
1. Simple Cucumber Report can be accessed under test-output/cucumber-reports/cucumber-pretty/index.html
1. Detailed Cucumber Report can be accessed under test-output/cucumber-reports/advanced-reports/overview-features.html
1. Appium Sever start and stop is handled programatically to allow the End to End Tests to run independently.


## Pre-Requisites:
1. Emulator shoudld be up and running before the tests can be run.(For runing the test, Pixel 2 API 26 Version Emulator has been used)
1. Need to be signed in to Google Calendar app , before the tests can be triggred for execution.
1. ANDROID_HOME and PATH environment variables should be set up correctly on the system where the test needs to be run.

 
 
## Assumptions:
1. Since the meeting has to be recurring for 3 days in the week , weekend days cannot be excluded, for example if the user wants to set a meeting on next Tuesday the recurring days would be Thursday and Saturday.
   Hence have made an assumption that weekends are not excluded from the list of days the user can schedule the meeting

 
## Instruction:
 To trigger the test first please clone the repository to any machine satisfying the conditions mentioned in Pre-Requisites section and thereafter navigate to the project directory.
 Please type in the below command and hit Enter to launch the tests:
 
 mvn clean install
 
