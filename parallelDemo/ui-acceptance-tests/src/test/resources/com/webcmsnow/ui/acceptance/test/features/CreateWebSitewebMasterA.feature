@ui-createwebsite-webMasterA
Feature: Demonstrate the UI create websites webMasterA

  Scenario Outline: Create webwebsite from a file base template webMasterA
    Given Login on <User> <Password> with web master role
    Then Create a website from <Template> with <Navigation>
    Then Rename a webeite to <newWebSiteName>
    Then Update website
    Then Naviage menu pages
    Then Change website title
    Then Remove newly createde website

    Examples: 
      | User       | Password | Template                                 | Navigation                          | newWebSiteName |
      | webMasterA | admin    | simple website for lessons::horizontal:1 | nav6h0:horizontal:2:bootstrap 3 nav | w1             |
