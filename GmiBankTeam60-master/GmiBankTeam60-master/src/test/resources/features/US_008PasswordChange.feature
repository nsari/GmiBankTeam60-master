@US008pwdChange
Feature: Password Change Should be done

  Background: User  should be logged in gmi bank and navigate to password page
    Given Go to the GMi Bank home page
    And click on user icon
    And sign in with a valid username and password
    Then Click on the password menu

  @US_008_01
  Scenario:The old password should not be used
    When User enters the old password as new password
    Then Check the fail message

# @US_008_02
#  Scenario: There should be at least one lowercase char for stronger password and see the level chart change accordingly
#    When  user clicks password text box
#    And enters pwd_lowercase password
#    Then Observe the strenght bar changing
#
#  @US_008_03
#  Scenario: There should be at least one uppercase char for stronger password
#    When  user clicks password text box
#    And enters pwd_uppercase password
#    Then Observe the strenght bar changing
#
#  @US_008_04
#  Scenario: There should be at least one digit char for stronger password
#    When  user clicks password text box
#    And enters pwd_digit password
#    Then Observe the strenght bar changing
#
#
#  @US_008_05
#  Scenario: There should be at least one special char for stronger password
#    When  user clicks password text box
#    And enters pwd_specialchar password
#    Then Observe the strenght bar changing
#
#  @US_008_06
#  Scenario: There should be at least seven chars for a stronger password
#    When user clicks password text box
#    And user enters one uppercase, lowercase, digit and special char
#    And enters three more chars
#    Then Observe the strenght bar is yellow
#
#  @US_008_07
#  Scenario:The new password should be confirmed
#    When User enter current password in password box
#    And User enter a valid new password in new password text box
#    And ser enter a valid new password confirmation password text box
#    And User click save button for password
#    Then Assert that pwd change is succeeded