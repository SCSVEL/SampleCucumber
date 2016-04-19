Feature: Sample FB feature Test

  Background: 										##### ALWAYS Background will run after @Before hook but before each scenario
    Given FB page is in open

  #Scenario: Enter First and Last Name
    ##Given FB Page is in open
    #When I enter values
    #Then I Should see the values

  #Scenario: Enter First and Last Name as PARAMETER
    ##Given FB Page is in open
    #When I enter values Arnold and Schwarzenegger
    #Then I Should see the values

  Scenario Outline: Enter First and Last Name -FOR LOOP
    ##Given FB Page is in open
    When I enter values <FirstName> and <LastName>
    Then I Should see the values

    Examples: 
      | FirstName | LastName    |
      | Sylvester     | Stallone     |
      | Arnold      | Schwarzenegger |
      | Hugh   | Jackman    |
