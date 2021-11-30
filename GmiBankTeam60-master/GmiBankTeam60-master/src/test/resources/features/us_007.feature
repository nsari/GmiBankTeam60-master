Feature: System should not allow to make updates with invalid credentials

  Background: Go to url
    Given  Navigate go to "gmi_url"
    Given  Log in
    Then Click user name icon
    Then Click user info item

  Scenario: US007_TC01 Email id cannot contain just digits or chars without "@" sign or ".com" extension
    Then Clear the Email box
    And Send a new email without @ sign
    And Check the invalid warning is displayed
    And Clear the Email box
    And Send a new email without .com  extension
    And Check the invalid warning is displayed

  Scenario: US007_TC02 There should not be an option of any other language other than Englisg or Turkish
    Then Check if there is only  English and Türkçe  displayed on Languauge dropdown menu

