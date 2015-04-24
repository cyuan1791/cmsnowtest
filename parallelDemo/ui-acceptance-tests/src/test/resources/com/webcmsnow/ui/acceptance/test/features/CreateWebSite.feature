@ui-createwebsite
Feature: Demonstrate the UI create websites

  Scenario Outline: Create webwebsite from a file base template
    Given Login on <User> <Password> with web master role
    
    Examples:
    | User       | Password |
    #| user | passwd | temp | tmp |
    | webMasterA | admin |
    #| webMsaterB | admin |