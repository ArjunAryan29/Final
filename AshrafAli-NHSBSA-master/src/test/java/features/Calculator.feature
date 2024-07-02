Feature: Calculator calculation on calculator.net

  Background:

    Given I open Calculator website in browser <"chrome">

  @inflation
  Scenario Outline: Calculate inflation rates for specific amounts and dates

    When I navigate to Inflation Calculator

    And I clear Inflation Calculator

  # Then I verify "Please provide a positive starting amount"
  # Line above was part of assignment, not sure what it means

    And I enter "<Amount>" and select "<MonthF>","<YearF>" and "<MonthL>","<YearL>"

    And I calculate

    Then I verify "<AmountF>" is the buying power for every amount
  # convert float

    Examples:
      | Amount | MonthF | YearF | MonthL | YearL | AmountF |
      | 200.00 | Average | 2011 | March | 2024 | 277.70 |
      | 300.00 | April | 2018 | April | 2020 | 307.00 |
      | 100.00 | Average | 1989 | January | 2001 | 141.21 |
      | 699.99 | July | 1974 | September | 2012 | 3279.00 |