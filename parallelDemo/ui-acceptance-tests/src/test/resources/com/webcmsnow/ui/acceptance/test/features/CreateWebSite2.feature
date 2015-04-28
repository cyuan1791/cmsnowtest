
@ui-createwebsite-2
Feature: Demonstrate the UI create websites w2

  Scenario Outline: Create webwebsite from a file base template w2
    Given Login on <User> <Password> with web master role
    Then Create a website
    Then Rename a webeite to <newWebSiteName>
    Then Update website
    Then Update website title
    Then Remove newly createde website
    
    Examples:
    | User       | Password | newWebSiteName |
    #| user | passwd | temp | tmp |
    | webMasterB | admin | w2 |
    #| webMsaterB | admin |