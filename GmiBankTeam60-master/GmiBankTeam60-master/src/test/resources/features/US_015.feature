@US15
Feature: US_015

  Background:
    Given User on the home page "gmi_url"
    Then User clicks menu icon
    And  User navigates to SignIn page
    And User enter valid "Us_015_username"
    And  User enters valid "Us_015_password"
    Then User cliks sign in button
    Then User clicks My Opertions
    Then User cliks My Accounts




  Scenario:View transfer transactions
    Then User clicks View Transfer
    And User verifies that Transfer transactions are displayed
    And User close driver



  Scenario: User verifies Account id and balance populated
    Then User verifies account type
    Then User verifies balance populated
    And User close driver