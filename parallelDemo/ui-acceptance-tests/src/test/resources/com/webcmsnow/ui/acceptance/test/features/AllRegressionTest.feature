@ui-createwebsite-All
Feature: Demonstrate the UI create websites webMasterA

  Scenario Outline: Create webwebsite from a file base template webMasterA
    Given Login on <User> <Password> with web master role
    Then Create a website from <Template> with <Navigation>
    Then Rename a webeite to <newWebSiteName>
    Then Update website
    Then Change website title
    Then Remove newly createde website

    Examples: 
      | User       | Password | Template                                 | Navigation                                     | newWebSiteName |
      | webMasterA | admin    | simple website for lessons::horizontal:1 | nav6h0:horizontal:2:bootstrap 3 nav            | w1             |
      | webMasterA | admin    | bsuite/b0::both:2                        | nav6h5:horizontal:3:bootstrap 3 Yamm3 MegaMenu | w1             |
      | webMasterA | admin    | template b2::horizontal:3                | nav6h0:horizontal:2:bootstrap 3 nav            | w1             |
      | webMasterA | admin    | b0 Demo One ::horizontal:2               | nav6h0:horizontal:2:bootstrap 3 nav            | w1             |
