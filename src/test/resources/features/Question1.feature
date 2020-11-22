Feature: To check the basic functionality of IMDB website

#  this test case is to navigte to top rated shows page
  Scenario: To verify when user enters some valid search item the results are displayed
    Given User is on IMDB webpage
    When User navigates to SideMenu
    And Selects "Top Rated Shows"
    Then assert that top rated show details are present

# this test case is to find game of thrones and verify title rating and number of reviews
  Scenario: To verify by searching particular show and click last watch link
    Given User is on IMDB webpage
    When User searches for "Game of Thrones"
    And clicks the lastest episode link
    Then verify title rating and number of reveiws
