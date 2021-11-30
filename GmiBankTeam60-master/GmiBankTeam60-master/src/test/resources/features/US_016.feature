@US16
Feature: US_016

  Background:
    Given User on the home page "gmi_url"
    Then User clicks menu icon
    And  User navigates to SignIn page
    And User enter valid "Us_016_username1"
    And  User enters valid "Us_016_password1"
    Then User cliks sign in button
    Then User clicks My Opertions


  Scenario: User should have at least 2 accounts
    Then User cliks My Accounts
    And Verifies that user has two account
    And User close driver

  Scenario: Money Transfer Process
    Then User clicks Money Transfer
    And User selects account from dropdown menu
    And User selects account from the to drop-down menu
    And User enters "amountOfTransfer" in the balance text box
    And User enters "descriptionOfTransfer" in the description text box
    And User click Make Transfer icon
    Then Assert  visible text
    And User close driver

