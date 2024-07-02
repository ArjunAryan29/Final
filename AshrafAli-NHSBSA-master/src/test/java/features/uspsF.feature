@usps
Feature: USPS Features

  Background:
    Given I look up a zip code using <"chrome">

  Scenario: Validate zip code for a given address on the Look Up a ZIP Code page
    When I enter a street address
    And I enter the city
    And I select the state
    And I click the Find button
    Then I can see that the correct zip code displays in the result

  Scenario: New Hiring Message Validation
    When I click on LOGO to go to home page
    And I navigate to bottom of the page
    And I click the Find Out more
    And I navigate to new tab
    Then I verify Now hiring message on the page


