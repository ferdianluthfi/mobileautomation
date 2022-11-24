## Introduction
This is a Maven project for Mobile Automation on Android devices by laveraging the simplicity of Appium. Below diagram is how this automation works.
Our automation script talking to Appium Driver. Appium Driver then gonna translate our script to a language that the phone can understand. 
in this scenario, Appium Driver translate our script that is written in java into steps that UIAutomator understand.


![Untitled Diagram drawio (2)](https://user-images.githubusercontent.com/36224775/203794139-fb7da210-d087-4784-aa25-bca9036b8163.png)



## Running Guide
1. You have to install Java, Appium, and Android SDK on your machine, please refer to <a href="https://support.smartbear.com/testcomplete/docs/app-testing/mobile/device-cloud/configure-appium/android-on-windows.html" target="_blank">this docs</a> for detailed steps.
2. Download the <a href="https://github.com/flutter/gallery/releases/download/v2.9.2/flutter_gallery_Android.apk" target="_blank"> the .apk file</a> and put it insde the apps folder at ``` src/main/resources/apps ```
3. Build the project on your favourite IDE (I'm using ecplise).
4. Start up Appium server using ``` appium ``` command on your terminal.
5. Connect your android debugging device or start your android emulator.
6. Change the UDID to your debugging device UDID, you can it at ```src/test/java/tests/BaseTest.java```
7. Run the test cases on ```src/test/java/tests/Home.java```

## Automation structure
Given the fact that the SDLC gonna be ScrumBan which is an Agile development methodology, I would recommend that the automation is gonna be this way.
There are two ways that the automation will run.

First, is when the developers merged their code to master or whenever there is a new apk/ipa. we can run our test case by trigger it manually via jenkins/github workflow.
Second, is running automatically every day using scheduler.

With this approach, we can lesser our manual testing effort, because we can check existing feature using automation everytime we need it. And also make sure that there is nothing broken everyday.


![Untitled Diagram drawio (3)](https://user-images.githubusercontent.com/36224775/203802624-3a3b299f-1d05-4faa-acd4-4fd4ec7b3f5b.png)
