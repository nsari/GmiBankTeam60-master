Feature:All users (user, employee, manager or admin) should
  be printed as a pdf file
  Scenario Outline: You should have all users' info as Name, last name and role on a pdf document
    Given user creates a connection using "jdbc:postgresql://157.230.48.97:5432/gmibank_db" , "techprodb_user" and "Techpro_@126"
    Then user provides the query "<query>" and sees first ten user info on pdf file
    Examples: pdf
      |query|
      |select * from jhi_user    |