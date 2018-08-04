Feature: Main Activity
  Scenario Outline: Test calculator basics
    Given I have a calculator activity
    When I enter operand1 <o1>
    And I enter operand2 <o2>
    And I select operator <operator>
    Then I should display <output>

    Examples:
      | o1 | o2 | operator | output |
      | 1  | 2  | +        | 3.0    |
      |100 | 4  | /        | 25.0   |
      | 3  | 5  | *        | 15.0   |
      | 45 | 15 | -        | 30.0   |