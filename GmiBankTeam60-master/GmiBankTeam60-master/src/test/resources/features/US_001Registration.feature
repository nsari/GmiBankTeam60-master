@Registration
  Feature: US_001 RegistrationPage (System should allow any user to register with valid credentials
    validating the success message)
    Background:
      Given User go to URL
      And User clicks on icon
      And User clicks on registerButton

    Scenario: US_001 TC_01 There should be a valid SSN respecting the "-" where necessary,
    it should be 9 digits long
      And User Click on SSN textBox
      And User Enter the SSN number
      Then User ssn should be valid

    Scenario: US_001 TC_02 There should be a valid name that contains chars and cannot be blank
      And User click on nameTextBox
      And  Enter "firstName"
      Then User firstName should be valid

    Scenario: US_001 TC_03 There should be a valid lastname that contains chars and it is a required field
      And User click on lastNameTextBox
      And User Enter "lastName"
      Then User lastName should be valid

    Scenario: US_001 TC_04 You can provide chars and digits to describe a valid address along with zip code
      And User clicks on adresTextBox
      And User Enter the adres
      Then User adres should be valid

    Scenario: US_001 TC_05 User should provide 10 digit-long mobilephone number as a required field respecting the "-"
      And User clicks on mobilPhoneNumber
      And User Enter the mobilePhoneNumber
      Then User mobilePhoneNumber should be valid

    Scenario: US_001 TC_06 User cannot use just digits,
      but can use any chars and digits along with them and of any length
      And User click on userNameTextBox
      And User Enter the userName
      Then User userName should be valid

    Scenario: US_001 TC_07 You should provide a valid email format that contains "@"sign and "." extensions
      And User click on emailTextBox
      And User Enter the email
      Then User email should be valid
      Then User click on newPassword
      Then User enter the newPassword
      Then User click on newPasswordConfirmation
      Then User enter the newPasswordConfirmation
      Then user click on registerButtonLast
















