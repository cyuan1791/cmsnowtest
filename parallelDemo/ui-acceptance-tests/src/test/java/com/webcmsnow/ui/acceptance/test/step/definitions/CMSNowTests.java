package com.webcmsnow.ui.acceptance.test.step.definitions;

import java.util.List;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.webcmsnow.ui.acceptance.test.common.RenameFailed;
import com.webcmsnow.ui.acceptance.test.common.World;
import com.webcmsnow.ui.acceptance.test.config.TestProperties;
import com.webcmsnow.ui.acceptance.test.config.spring.TestConfig;
import com.webcmsnow.ui.acceptance.test.interaction.objects.WebCMSPage;
import com.webcmsnow.ui.acceptance.test.step.test.CMSNavigate;

import static org.junit.Assert.*;

@ContextConfiguration(classes = TestConfig.class)
public class CMSNowTests extends AbstractStepDefinition {
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
		this.webCMSPage.setSenario(scenario);
		super.before(scenario);
	}

	@Given("^Login on (.*?) (.*?) with web master role$")
	public void login_on_with_web_master_role(String user, String password)
			throws Throwable {
		System.out.println(testProperties.getApplicationWebBaseUrl());
		System.out.println(user + password);
		webCMSPage.goHome();
		webCMSPage.login(user, password);
		// webCMSPage.createWebsite("");
		// webCMSPage.renameWebsite("w1");
		// webCMSPage.removeWebsite();
	}

	@Then("^Create a website from (.*?) with (.*?)$")
	public void create_a_website(String Template, String Navigation) throws Throwable {
		System.out.println("Template: " + Template);
		webCMSPage.createWebsiteFromFileTemplate(Template, Navigation);
	}

	@Then("^Rename a webeite to (.*?)$")
	public void rename_a_webeite_to_w(String newWebSite) throws Throwable {
		
		// Check if newWebSite exist
		List<WebElement> elems = webCMSPage.getDriver().findElements(By.linkText(newWebSite));
		if (elems.size() > 0) {
			// newWebSite exist, remove it
			System.out.println("Website exist. Remove it.");
			webCMSPage.removeWebsite(newWebSite);
		}
		webCMSPage.renameWebsite(newWebSite);
		
	}
	@Then("^Naviage menu pages$")
	public void navwebsite() throws Throwable {
		CMSNavigate.basicNavigate(webCMSPage);
    	
	}
	
	@Then("^Check 00_basic modules$")
	public void check_00basicmodule() throws Throwable {
		CMSNavigate.check_00_basic_module(webCMSPage);
    	
	}
	@Then("^Check basic_01 and basic_02 modules$")
	public void check_0102basicmodule() throws Throwable {
		CMSNavigate.check_other1_modules(webCMSPage);
    	
	}
	
	@Then("^Check 02_compose, 03_animate, 04_link and 05_misc modules$")
	public void check_module_rest() throws Throwable {
		CMSNavigate.check_module_others(webCMSPage);
    	
	}



	@Then("^Update website$")
	public void updatewebsite() throws Throwable {
		webCMSPage.updateWebsite();

	}

	@Then("^Change website title$")
	public void updatewebsitetitle() throws Throwable {
		String newTitle = "b0test";
		// webCMSPage.updateWebsite();
		webCMSPage.changeWebsiteTitle(newTitle);
		webCMSPage.updateWebsite();
		Assert.assertTrue(
				"Update page title and read back check and should be the same",
				webCMSPage.getMyWebsiteTitle().equals(newTitle));
	}

	@Then("^Remove newly createde website$")
	public void remove_newly_createde_website() throws Throwable {
		webCMSPage.removeWebsite("");
	}

	@After
	public void takeFailureScreenShot() {

		// Output extra info to report
		if (scenario.isFailed()) {
			myTakeScreenShot(webCMSPage.getDriver());
		}
		webCMSPage.getDriver().quit();
	}

}
