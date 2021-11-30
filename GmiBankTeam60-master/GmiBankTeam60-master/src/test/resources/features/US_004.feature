@us004UserLogin
Feature:Login page should accessible with valid credentials
  Scenario: User should sign in with valid credentials
    Given User navigates to url "gmi_url"
    And user clicks on iconAccountMenu
    Then user clicks on signin button

  Scenario: User should enter a valid username
    Given user types a valid username

  Scenario: User should enter a valid password
    Given user enters a valid password


  Scenario: User should verify whether a successfull sign in done or not
    Given user clicks on signinSubmit button
    And verifies that sign in is done successfully

  Scenario: There should be an option to cancel login
    Given user provides valid username and password
    And clicks on cancel button and verifies.