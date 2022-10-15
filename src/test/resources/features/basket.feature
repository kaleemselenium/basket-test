Feature: Validate the basket has the product added

  Scenario: Verify the basket has the correct product
    Given user on home page
    When user searches for the product "Table"
    And adds random product from the result
    And user navigates to the basket page
    Then user sees the correct product in the basket page

