@US03pwdR
Feature: Registration page should restrict password usage to a secure and high level passcode

  Background: User go to the gmi bank url
    Given User go to the GMi Bank home page
    And User click on user icon
    And User click on the registration menu
    And Click on New Password textbox
    Then  Assert that strenght bar is red

  @US03pwdR01
  Scenario: There should be at least one lowercase char for stronger password and see the level chart change accordingly
    And Enter a password with one uppercase letter
    And Observe that strenght bar is yellow
    And Enter one lowercase letter to password test box
    And Strength Bar must be green
    And Click on password confirmation textbox
    Then Copy new password text box value to new password confirmation texbox