Feature:System should allow Admin to create a new Account

  Background: Go to  url
    Given  Navigate go to "gmi_url"
    Given  Log in
    Then Click user name icon
    Then Click user info item
#  And Click language dropdown menu
 # And Click English on language dropdown menu
    And Click the My Operation item
    And Click the Manage Account item
    And Click Create a new Account


  Scenario: US019_TC01 User should create a description for the new account and it cannot be blank
    Then Fill the Description Textbox
    And Check the Description TextBox is filled

  Scenario: US019_TC02 User should provide a balance for the first time account creation as Dollar
    Then Fill the Balance Textbox with digits

  Scenario: US019_TC03 User can select an account type as CHECKING, SAVING, CREDIT_CARD or INVESTING
    Then  click acount type dropdown
    And select an account type as CHECKING
    And click acount type dropdown
    And select an account type as SAVING
    And click acount type dropdown
    And  select an account type as CREDIT_CARD
    And click acount type dropdown
    And select an account type as INVESTING

  Scenario: US019_TC04 Account status should be defined as ACTIVE, SUSPENDED or CLOSED
    Then  click acount status dropdown
    And  Account status should be defined as ACTIVE
    And click acount status dropdown
    And Account status should be defined as SUSPENDED
    And click acount status dropdown
    And Account status should be defined as  CLOSED


  Scenario: US019_TC05 User can select an employee from the drop-down
    Then  click employee dropdown
    Then select an employee from the drop-down