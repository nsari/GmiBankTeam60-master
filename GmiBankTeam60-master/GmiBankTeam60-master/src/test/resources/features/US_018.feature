
Feature: System should allow Admin to see view option
  Scenario:Admin can make edit using view option
    Given Admin navigates to "gmibank_signin_url"
    Then types username and password
      |username    |  password|
      |team60_admin|Team60admin.|
      |louie.crist |Af!RnGJVfiHA |
    And clicks on sign in button on login page
    Then clicks on the Administration dropdown
    Then clicks on User Management
    Then clicks on the date arrow button
    And searches for new registrant "{string}"
    Then clicks on view section
    Then sees user info as validaton valides login name can be seen
    And clicks on back button
    And clicks on adminDropdown and signs out


    Scenario: All customers should show up on manage customers so Admin can access manage customer
      Given Admin navigates to "gmibank_signin_url"
      Then types username and password
        |username    |  password|
        |team60_admin|Team60admin.|
        |louie.crist |Af!RnGJVfiHA |
      And clicks on sign in button on login page
      Given clicks on My Operations
      And clicks on Manage Customer
      And admin sees a message "You are not authorized to access this page." and verifies
      And clicks on Manage Accounts
      And admin sees a mesage "You are not authorized to access this page." and verifies the message
      And clicks on adminDropdown and signs out

