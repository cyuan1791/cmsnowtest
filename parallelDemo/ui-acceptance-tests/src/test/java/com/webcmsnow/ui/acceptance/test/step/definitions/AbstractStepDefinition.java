package com.webcmsnow.ui.acceptance.test.step.definitions;

import com.webcmsnow.ui.acceptance.test.common.World;

import cucumber.api.Scenario;
import cucumber.api.java.After;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Common methods for all step definitions
 */
public abstract class AbstractStepDefinition {

    protected Scenario scenario;

    @Autowired
    protected World world;

    /**
     * Get a reference to the current cucumber scenario
     * Supports writing text and xml to report within test steps
     * @param scenario
     */
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    protected void embedTextInReport(String text) {
        scenario.write(text);
    }

    protected void embedXmlInReport(String xml) {
        xml = "<textarea readonly>" + xml + "</textarea>";
        scenario.write(xml);
    }
    
    // // take sceenshot, only works using "mvn install"
    protected void myTakeScreenShot(WebDriver driver) {
    	try {
			scenario.write("Current Page URL is "
					+ driver.getCurrentUrl());
			byte[] screenshot = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		} catch (WebDriverException somePlatformsDontSupportScreenshots) {
			System.err.println(somePlatformsDontSupportScreenshots
					.getMessage());
		}
    }
    
}
