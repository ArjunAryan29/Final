@Amazon
Feature: Amazon Search verification

  Background:
    Given I open Google website in browser <"chrome">

  Scenario Outline: User search for keywords after search
    When I enter text <"amazon"> and navigate to amazonwebsite
    And  I enter "<Keyword1>" in search and click on search
    And I look for the text "<Keyword2>"
    Then The text "<Keyword2>" is verified in the page
    Examples:
      |Keyword1             |Keyword2|
      |programming          |the art |
      |software development |clean architecture|