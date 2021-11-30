Feature: User info segment (User Settings) should be editable on Homepage
  Background: Go to url
    Given  Navigate go to "gmi_url"
    Given  Log in
    Then Click user name icon
    Then Click user info item

  Scenario: US006_TC01 User info segment (User Settings) should be editable on Homepage

    Then Check if the First Name item is displayed
    And Check if the Last Name item is displayed
    And Check if the Email item is displayed
    And Check if the Language item is displayed


  Scenario: US_006_TC02

    Then Check if English is displayed on Languauge dropdown menu
    And Check if Turkish is displayed on Language dropdown menu

  Scenario: US_006_TC03
    Then Delete the name in the First Name box
    And Send a new name to the First Name box
    And Click on the Save button
    And Check  if the successful popup message is displayed

  Scenario: US_006_TC04
    Then Delete the last name in the Last Name box
    And Send a new last name to theLast Name box
    And Click on the Save button
    And Check  if the successful popup message is displayed

  Scenario: US_006_TC05
    Then Delete the email in the Email box
    And Send a new email to the Email box adding "@" sign and ".com" extension
    And Click on the Save button
    And Check  if the successful popup message is displayed