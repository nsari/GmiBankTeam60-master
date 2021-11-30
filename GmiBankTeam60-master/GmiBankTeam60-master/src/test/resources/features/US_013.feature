@employeecreateaccount
Feature: An employee can create new account
  Scenario:  employee should sign in and clicks manage accounts

    Given An employee navigate signin url "gmibank_signin_url"
    Then provides username
    Then provides password
    And clicks on sign in button
    When clicks on language menu
    Then clicks on English
    And clicks on manage accounts
    And clicks on create new account

  Scenario: US013_TC01 User should create a description for the new account and it cannot be blank
    Given Employee writes description as Saving Account

  Scenario: US013_TC02 User should provide a balance for the first time account creation as Dollar
    Given employee clicks on balance text box
    And provide balance as number

  Scenario: US013_TC03 User can select an account type as CHECKING, SAVING, CREDIT_CARD or INVESTING
    Given Employee clicks on account type dropdown
    And selects its status such as CHECKING

  Scenario: US013_TC04 Account status should be defined as ACTIVE, SUSPENDED or CLOSED
    Given Employee clicks on account status type dropdown
    And clicks on its type such as ACTIVE


  Scenario: US013_TC05 User can select an employee from the drop-down
    Given Employee clicks on employee
    And verify it is selected or not
    And employee clicks on save button to create an account
