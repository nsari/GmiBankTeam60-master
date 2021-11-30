@createCustomer
Feature:  US_009 Create a customer



  Scenario:User can search for a new applicant by their SSN and see all their registration info populated

    Given User navigate to  "gmibankurl"
    Given User should  login
    Given User should  click My Opertions
    And User should  select Manage Customers
    And User should  click Create a New Customer
    And User should  enter ssn
    And User should  click Search button
    And User should  see success message
    And User should  see firstname
    And User should  see lastname
    And User should  see Email
    And User should  see mobile phone
    And User should  see Adress
    Then User should  see Create Date