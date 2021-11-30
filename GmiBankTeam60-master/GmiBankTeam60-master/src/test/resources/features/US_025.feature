Feature: System should allow to create new countries using api end point
  "https://www.gmibank.com/api/tp-countries" if not created already
  Scenario:User can Just create each country 1 by 1
    Given use endpoint "https://www.gmibank.com/api/tp-countries" and create new countries
    Then read all countries from end point "https://www.gmibank.com/api/tp-countries"
    And verify new countries