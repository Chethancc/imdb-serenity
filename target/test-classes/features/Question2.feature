Feature: To create new User and test login for the new user created

  Scenario:To Signup and Create New Account
    Given User is on IMDB webpage
    And user Clicks on Signin Link
    And navigate to Create New Account Page
    And enters the user accountDetails with "Profile1"
    Then Account must be created Successfully


  Scenario:To verify user is able to login to the above created account
    Given User is on IMDB webpage
    And user Clicks on Signin Link
    And clicks Sign in with IMDb
    And enters username and password as per "Profile2"
    Then user must be succesfully logged in
