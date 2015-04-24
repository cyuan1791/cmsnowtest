package com.webcmsnow.ui.acceptance.test.step.definitions;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.webcmsnow.ui.acceptance.test.common.World;
import com.webcmsnow.ui.acceptance.test.config.TestProperties;
import com.webcmsnow.ui.acceptance.test.config.spring.TestConfig;
import com.webcmsnow.ui.acceptance.test.interaction.objects.GoogleSearchPage;

import static org.junit.Assert.assertTrue;

@ContextConfiguration(classes= TestConfig.class)
public class CreateWebsite extends AbstractStepDefinition {
    @Autowired
    private GoogleSearchPage googleSearchPage;
    @Autowired
    private TestProperties testProperties;

    /**
     * pass the current cucumber scenario to abstract class to
     * support writing to cucumber test report due to cucumber
     * limitations
     */
    @Before
    public void before(Scenario scenario) {
        super.before(scenario);
    }

    @Given("^Login on user with web master role$")
    public void login_on_user_with_web_master_role() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("given");
    }

    @Then("^create a website from template website and navigation style$")
    public void create_a_website_from_template_website_and_navigation_style() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	System.out.println("given");
    }

    @Then("^Update and Check the website$")
    public void update_and_Check_the_website() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	System.out.println("given");
    }
}
