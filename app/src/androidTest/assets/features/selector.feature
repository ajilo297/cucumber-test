@selector
Feature: Selector
  Scenario: I click on Login
    Given I have a Selector Activity
    When I click on Login button
    Then I should see login activity


  Scenario: I click on Calculator
    Given I have a Selector Activity
    When I click on Calculator button
    Then I should see Calculator activity