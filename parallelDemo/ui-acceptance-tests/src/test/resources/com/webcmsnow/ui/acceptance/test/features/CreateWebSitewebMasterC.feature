@ui-createwebsite-webMasterC
Feature: Demonstrate the UI create websites webMasterC

  Scenario Outline: Create webwebsite from a file base template webMasterC
    Given Login on <User> <Password> with web master role
    Then Create a website from <Template> with <Navigation>
    Then Rename a webeite to <newWebSiteName>
    Then Update website
    Then Check 02_compose, 03_animate, 04_link and 05_misc modules
    Then Remove newly createde website

    Examples: 
      | User       | Password | Template                   | Navigation                          | newWebSiteName |
      | webMasterC | admin    | b0 Demo One ::horizontal:2 | nav6h0:horizontal:2:bootstrap 3 nav | w3             |
