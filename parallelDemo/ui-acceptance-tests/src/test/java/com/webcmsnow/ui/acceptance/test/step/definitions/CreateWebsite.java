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
import com.webcmsnow.ui.acceptance.test.interaction.objects.WebCMSPage;

import static org.junit.Assert.assertTrue;

@ContextConfiguration(classes = TestConfig.class)
public class CreateWebsite extends AbstractStepDefinition {
	@Autowired
	private WebCMSPage webCMSPage;
	@Autowired
	private TestProperties testProperties;

	/**
	 * pass the current cucumber scenario to abstract class to support writing
	 * to cucumber test report due to cucumber limitations
	 */
	@Before
	public void before(Scenario scenario) {
		super.before(scenario);
	}

	@Given("^Login on (.*?) (.*?) with web master role$")
	public void login_on_with_web_master_role(String user, String password)
			throws Throwable {
		System.out.println(testProperties.getApplicationWebBaseUrl());
		System.out.println(user+password);
		webCMSPage.login(user, password);
	}

}
