Feature: A demo for failed test

@failedTest
Scenario Outline: Login with valid credentials
   Given user is on login page
   When user enters <username> and <password>
   And clicks on login button
   Then user lands on products page
   
   Examples:
   |  username     |  password  |
   |locked_out_user|secret_sauce| 
