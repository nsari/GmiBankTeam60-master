@dateCreation
Feature: Date should be created on the time of account creation
  Scenario: Employee should sign in with valid credentials
    Given Employee should sign in his account and clicks manage accounts
Scenario:US014_TC01 The date cannot be typed earlier, in the past, at the time of creation an account
When user provides all required places such as description,account
And user enters today's date on the Create Datetextbox and verifies it is correct date ot not


Scenario: US014_TC02 The date should be created as month, day, year, hour and minute
And user checks the order of date as given format and verify
Then selects date for the closed Datetextbox
And user verifies closed date matches with entering data
And user clicks on save button


Scenario: US014_TC03 User can choose a user from the registration and it cannot be blank
When User clicks on manage accounts
And user clicks on manage customer
Then User types SSN number
And User clicks on search button
Then User fills all required sections out

Scenario: US014_TC04 The user can choose an account created on manage accounts
When user selects account from dropdown
And  verifies it is chosen or not


Scenario: US014_TC05 User can select Zelle Enrolled optionally and save it
When User clicks on zelle enrolled check box
And User clicks on save button for customer create
And User sees zelle enrolled is selected or not