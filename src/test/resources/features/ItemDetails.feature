Feature: ItemDetails

  Background: Precondition
    Given The user navigates to the details of the item "Sauce Labs Fleece Jacket"

  Scenario: Verify the item details page
    Then The user verifies that the item details UI is right

  Scenario: Go back to shopping page
    When The user clicks on back to products
    Then The application redirects to the shopping page