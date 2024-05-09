Feature: BurgerMenu

  Background: Precondition
    Given The user is logged in and open the burger menu

  Scenario: Logout
    When The user clicks on the logout option
    Then The application redirects to the login page

  Scenario: About
    Then The user verifies that the about link is "https://saucelabs.com/"