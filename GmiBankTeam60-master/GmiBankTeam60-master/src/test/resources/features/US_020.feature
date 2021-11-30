Feature: System should allow to read all customers info using api end point
  @us20tc1
  Scenario:TC001 Read all customers you created and validate them from your data set
    Given user enters to url to get token "https://www.gmibank.com/api/authenticate"
    Then Read all customers using with api endpoint "https://www.gmibank.com/api/tp-customers"
    And validate customer datas

  @us20tc2
  Scenario:TC002 Read all customers you created and validate them 1 by 1
    Given read customer datas using api endpoint "https://www.gmibank.com/api/tp-customers"
    Then validate customers one by one