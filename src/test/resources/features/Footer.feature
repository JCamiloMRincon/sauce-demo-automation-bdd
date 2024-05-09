Feature: Footer

  Background: Precondition
    Given The user navigates to the shopping page

  Scenario: Verify the social media in the footer
    Then The user verifies that the links are right: "https://twitter.com/saucelabs", "https://www.linkedin.com/company/sauce-labs/", "https://www.facebook.com/saucelabs"