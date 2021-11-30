@Registration002
  Feature: US_002  System should not allow anyone to register with invalid credentials
    seeing the message "If you want to sign in, you can try the default
    accounts:- Administrator (login="admin" and password="admin")
    - User (login="user" and password="user").

    Background:
      Given User go to  URL
      And User clicks on  icon
      And User clicks on registerButton

  Scenario: US_002 TC_01 SSNTextBox on the registration page should not be left blank
    And User click on the ssnTextBox
    And User does not enter the SSNTextBox
    Then User see an SSN error message

    Scenario: US_002 TC_02 firstNameTextBox on the registration page should not be left blank
      And User click on the firstNameTextBox
      And User does not enter the firstNameTextBox
      Then User see an firstname error message

  Scenario: US_002 TC_03 lastNameTextBox on the registration page should not be left blank
    And User click on the lastNameTextBox
    And User does not enter the lastNameTextBox
    Then User see an lastname error message

  Scenario: US_002 TC_04 adresTextBox on the registration page should not be left blank
    And User click on the adresTextBox
    And User does not enter the adresTextBox
    Then User see an adres error message

  Scenario: US_002 TC_05 phoneNumberTextBox on the registration page should not be left blank
    And User click on the phoneNumberTextBox
    And User does not enter the phoneNumberTextBox
    Then User see an phoneNumber error message

  Scenario: US_002 TC_06 userNameTextBox on the registration page should not be left blank
    And User click on the userNameTextBox
    And User does not enter the userNameTextBox
    Then User see an userName error message

    Scenario: US_002 TC_07 emailTextBox on the registration page should not be left blank
      And User click on the emailTextBox
      And User does not enter the emailTextBox
      Then User see an email error message

  Scenario: US_002 TC_08 newPasswordTextBox on the registration page should not be left blank
    And User click on the newPasswordTextBox
    And User does not enter the newPasswordTextBox
    Then User see a newPassword error message

  Scenario: US_002 TC_09 newPasswordConfirmation on the registration page should not be left blank
    And User click on the newPasswordConfirmation
    And User does not enter the newPasswordConfirmation
    Then User see a passwordConfirmation error message

    Scenario: US_002 TC_10 SSN number cannot be of any chars nor spec chars except "-"
      And User click on the SSNTextBox
      And User enter an SSNnumber with chars or specific chars
      Then User see an invalid SSN error message

  Scenario: US_002 TC_11 Mobilephone number cannot be of any chars nor spec chars except "-"
    And User click on the phoneTextBox
    And User enter a mobilePhoneNumber with chars or spesific chars
    Then User see an invalid mobilePhoneNumber error message

  Scenario: US_002 TC_12 email id cannot be created without "@" sign and "." extensions
    And User clicks on emailTextBox
    And User enter an email without @ and . extensions
    Then User see an invalid email error message