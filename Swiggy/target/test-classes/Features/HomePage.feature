Feature: Swiggy Application - Signin

Scenario: Signin swiggy application with registered mobile number
Given user launch the swiggy application "url"
And user valiadtes the page tittle
When user click on locateMe button
Then user valiadtes the page tittle
When user clicks on login button
Then login page should be displayed 
And user enters the phone number
And user click on loginbutton
Then enter otp section will be shown


Scenario: Signin swiggy application with unregistered mobile number
Given user launch the swiggy application "url"
And user valiadtes the page tittle
When user click on locateMe button
Then user valiadtes the page tittle
When user clicks on login button
Then login page should be displayed 
And user enters the unregistered phone number
And user click on loginbutton
Then signup popup should be shown