Feature: database testing ders bank8
  Background: create connection ders bank8
    Given database user creates a connection with database using "jdbc:postgresql://157.230.48.97:5432/gmibank_db" , "techprodb_user" and "Techpro_@126"


  @customer
  Scenario Outline: read and validate customer data
    Then user reads the customer data using "<query>" and "<columnName>"
    #Then user see database customer info
    Then user validates customer data

    Examples: customer data
      | query                     | columnName |
      | Select * from tp_customer | ssn |


  @country
  Scenario Outline: read and validate with country
    Then user reads the country data using "<query>" and "<columnName>"
    #Then user see database country info
    Then user validates all country data

    Examples:
      | query                    | columnName |
      | Select * from tp_country | id       |

  @state
  Scenario Outline: read and validate with state
    Then user reads the names of the state from USA "<query>" and "<columnName>"
    Then user validates the names of the state from USA data

    Examples:
      | query                                                                                                   | columnName |
      | select state from tp_customer where country_id in (select id from tp_country where name='USA')          | state      |

