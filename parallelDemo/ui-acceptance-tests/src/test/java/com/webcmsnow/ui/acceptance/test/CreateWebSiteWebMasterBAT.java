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
        tags = { "@ui-createwebsite-webMasterB", "~@ignore" },
        plugin = { "json:target/CreateWebSiteWebMasterB.json", "html:target/cucumber-report/CreateWebSiteWebMasterB" })
public class CreateWebSiteWebMasterBAT
{
}
