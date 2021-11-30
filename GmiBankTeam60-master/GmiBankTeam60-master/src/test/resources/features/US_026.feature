Feature:Api testing US_026

  @US_026_read_countries
  Scenario: read countries
    Then read all countries and write country ids to txt using api endpoint "https://www.gmibank.com/api/tp-countries"
#    Given user enters to url to get token "https://www.gmibank.com/api/authenticate"




  @US_026_creata_country
    Scenario: Create a country
    And user creates an country "https://www.gmibank.com/api/tp-countries"


  @US_026_validate_country
    Scenario: Validate created country
    Then validate created a country

  @US_026_update_country
    Scenario Outline: Update country
    And update created a country using api end point "https://www.gmibank.com/api/tp-countries"  "<name>" and its extension "<id>"

    Examples: Update country
      | name              | id    |
      | US_026 Ulkesi | 103614 |

  @US_026_validate-updated_country
  Scenario Outline: validate countries
    And user validates this updated country with Api end point "https://www.gmibank.com/api/tp-countries" "<name>" and its extension "<id>"
    Examples: Update country
      |name|id|
      |US_026 Ulkesi|103614|

