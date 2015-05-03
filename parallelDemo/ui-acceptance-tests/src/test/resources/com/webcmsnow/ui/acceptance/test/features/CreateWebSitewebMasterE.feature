@ui-createwebsite-webMasterE
Feature: Demonstrate the UI create websites webMasterE

  Scenario Outline: Create webwebsite from a file base template webMasterE
    Given Login on <User> <Password> with web master role
    Then Create a website from <Template> with <Navigation>
    Then Rename a webeite to <newWebSiteName>
    Then Update website
    Then Naviage menu pages
    Then Change website title
    Then Remove newly createde website

    Examples: 
      | User       | Password | Template          | Navigation                                     | newWebSiteName |
      | webMasterE | admin    | bsuite/b0::both:2 | nav6h5:horizontal:3:bootstrap 3 Yamm3 MegaMenu | w5             |
