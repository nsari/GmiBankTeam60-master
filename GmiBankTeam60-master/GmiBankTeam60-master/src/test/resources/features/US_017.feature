Feature: Admin role
  Background:
    Given Admin navigates to "gmibank_signin_url"
    Then types username and password
      |username    |  password|
      |team60_admin|Team60admin.|
      |louie.crist |Af!RnGJVfiHA |
    And clicks on sign in button on login page
    Then clicks on the Administration dropdown
    Then clicks on User Management

  @admin
  Scenario: Admin activates user as activated and validate activation is done
    Then clicks on the date arrow button
    And searches for new registrant "{string}"
    Then clicks on edit to activate and save for validation
    And  clicks on adminDropdown and signs out

    @adminforrole
    Scenario:  Admin activates user as a role employee and validate role
      Then clicks on create a new user
      And completes all required fields such as role employee
      And  clicks on save button sees message for validation

