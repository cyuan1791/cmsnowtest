@ui-createwebsite-webMasterD
Feature: Demonstrate the UI create websites webMasterD

  Scenario Outline: Create webwebsite from a file base template webMasterD
    Given Login on <User> <Password> with web master role
    Then Create a website from <Template> with <Navigation>
    Then Rename a webeite to <newWebSiteName>
    Then Update website
    Then Naviage menu pages
    Then Update website title
    Then Remove newly createde website

    Examples: 
      | User       | Password | Template          | Navigation                                     | newWebSiteName |
      | webMasterD | admin    | bsuite/b0::both:2 | nav6h5:horizontal:3:bootstrap 3 Yamm3 MegaMenu | w4             |
