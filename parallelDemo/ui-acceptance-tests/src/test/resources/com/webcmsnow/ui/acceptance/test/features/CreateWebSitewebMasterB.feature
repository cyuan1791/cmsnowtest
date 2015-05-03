@ui-createwebsite-webMasterB
Feature: Demonstrate the UI create websites webMasterB

  Scenario Outline: Create webwebsite from a file base template WebMasterB
    Given Login on <User> <Password> with web master role
    Then Create a website from <Template> with <Navigation>
    Then Rename a webeite to <newWebSiteName>
    Then Update website
    Then Naviage menu pages
    Then Change website title
    Then Remove newly createde website

    Examples: 
      | User       | Password | Template                  | Navigation                          | newWebSiteName |
      | webMasterB | admin    | template b2::horizontal:3 | nav6h0:horizontal:2:bootstrap 3 nav | w2             |
