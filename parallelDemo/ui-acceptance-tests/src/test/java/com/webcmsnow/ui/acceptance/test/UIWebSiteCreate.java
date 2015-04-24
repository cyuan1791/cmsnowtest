package com.webcmsnow.ui.acceptance.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

import com.webcmsnow.ui.acceptance.test.config.TestProperties;

/**
 * This class is a duplicate of UIDemonstrationAT.class and exists purely to
 * demonstrate running tests in parallel and reporting to a different directory
 *
 * Run cucumber scenarios tagged as "@ui-demo"
 * Write HTML report out to UIDemonstrationAT folder
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        tags = { "@ui-createwebsite", "~@ignore" },
        plugin = { "json:target/ParallelUIDemonstrationAT.json", "html:target/cucumber-report/ParallelUIDemonstrationAT" })
public class UIWebSiteCreate
{
}
