@ui-createwebsite
Feature: Demonstrate the UI create websites

  Scenario Outline: Create webwebsite from a file base template
    Given Login on "User" "Password" with web master role
    Then create a website from "Template" website and "navigation" style
    Then Update and Check the website has "Content"
    
    Examples:
    | User       | Password | Template | Content |
    | user | passwd | temp | tmp |
    #| webMasterA | test123 | b0 | b0 |
    #| webMsaterB | test123 | b0 | b0 |