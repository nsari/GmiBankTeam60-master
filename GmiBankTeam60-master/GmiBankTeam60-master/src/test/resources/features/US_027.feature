Feature: System should allow to delete states using api end point
  "https://www.gmibank.com/api/tp-states/1803"

  Scenario Outline: User can just delete each state one by one
    Given create a state from end point  "<end_point>"
    And delete state using  "<end_point>" and its extension "<name>"
    Then  When user verify if states  "<name>"


    Examples: Delete States
      |end_point|name    |
      | https://www.gmibank.com/api/tp-states|/Farmington|