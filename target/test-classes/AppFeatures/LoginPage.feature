Feature: Login page feature

Scenario: Login page title
Given user is on login page
When user gets the title of the page 
Then page title should be "Login - My Store"

Scenario: Forgot password link
Given user is on login page
Then forgot your password link should be displayed

Scenario: Login with correct credentials
Given user is on login page 
When user eneters username "er.priyanka693@gmail.com"
And user enters password "123456"
And user click on login button
Then user gets the title of the page 
And page title should be "My account - My Store"
