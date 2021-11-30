@login
Feature: LogIn Test

  Scenario: Login Page
    Given User navigates go to "gmi_url"
    And User clicks on iconAccountMenu
    And User clicks on  sigInHomePage button
    And User provides username
    And User provides password
    Then User clicks on Sign in button