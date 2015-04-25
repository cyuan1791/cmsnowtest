@ui-createwebsite
Feature: Demonstrate the UI create websites

  Scenario Outline: Create webwebsite from a file base template
    Given Login on <User> <Password> with web master role
    Then Create a website
    Then Rename a webeite to <newWebSiteName>
    Then Update website
    Then Remove newly createde website
    
    Examples:
    | User       | Password | newWebSiteName |
    #| user | passwd | temp | tmp |
    | webMasterA | admin | w1 |
    #| webMsaterB | admin |