@api_demo
Feature: Api testing Demo

  @countryRead
  Scenario: read and validate country
    Given read all countries data using with api endpoint "https://www.gmibank.com/api/tp-countries"
    Then validate it is readable or not


  @countryCreate
  Scenario: Create a country
    And create country "https://www.gmibank.com/api/tp-countries"
    Then validate it is created or not


  @countryUpdate
  Scenario Outline:  Update country
    Then update created a country using api end point "https://www.gmibank.com/api/tp-countries"  "<name>" and its extension "<id>"
    And validate it is updated or not

    Examples: Update country
      | name              | id     |
      | Team60SelamMillet | 103638 |

  @countryDelete
  Scenario Outline: Delete country
    Given delete updated a country using endpoint "<endPoint>" and its extension "<id>"
    And validate it is deleted or not using "<id>"

    Examples: Delete Country
      | endPoint                                 | id      |
      | https://www.gmibank.com/api/tp-countries | /103638 |

  @countryDataBase
  Scenario Outline: All countries should be retrieved by database and validated
    Given user should create a connection with db using "jdbc:postgresql://157.230.48.97:5432/gmibank_db" , "techprodb_user" and "Techpro_@126"
    And user should read all countries data using "<query>" and "<columnName>"
    Then validates countries exist or not
    Examples:
      | query                    | columnName |
      | select * from tp_country | name       |

  @countryPDFGenerator
  Scenario Outline: You should have first ten countries' names and their ids on a pdf document
    Given user should create a connection using "jdbc:postgresql://157.230.48.97:5432/gmibank_db" , "techprodb_user" and "Techpro_@126"
    Then user should provide the query "<query>" and sees first ten country datas on pdf
    Examples: pdf
      | query                    |
      | select * from tp_country |