@UbdateCustomer
Feature: US_010 Address of customer can be created

  Background:

  Scenario: Address of customer can be created
    Given User should navigate to "gmibankurl"
    And User should login the gmibank
    And User should create new customer
    And User should search the customer with ssn

  Scenario:Zip Code  should be provided and cannot be left as blank
    And User should enter zipCode "Zip_Code"

  Scenario:Country should be typed and cannot be blank
    And User sould enter Country "Country"

  Scenario:State should be provided as US state and cannot be blank
    And User should enter State"state"

  Scenario:City should be provided and cannot be left as blank
    And User should enter City "City"








