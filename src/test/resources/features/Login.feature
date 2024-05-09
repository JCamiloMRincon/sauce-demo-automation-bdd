Feature: Login

  Background: Precondition
    Given The user navigates to the login page

  @regression
  Scenario: Invalid credentials
    When The user types the username "locked_out_user" with the password "secret_sauce" and clicks on the login button
    Then An error message must be displayed indicating "Epic sadface: Sorry, this user has been locked out."

  @regression
  @smoke
  Scenario: Verify the login page
    Then The user verifies that the login page UI is right