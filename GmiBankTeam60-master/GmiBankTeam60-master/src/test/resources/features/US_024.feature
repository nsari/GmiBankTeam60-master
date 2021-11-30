Feature:System should allow to create new states using api end point
  "https://www.gmibank.com/api/tp-states" if not created already
  @us24
  Scenario: User can Just create each state one by one
    Given use endpoint "https://www.gmibank.com/api/tp-states" and create new states
    Then read all states from end point "https://www.gmibank.com/api/tp-states"
    And verify new states
