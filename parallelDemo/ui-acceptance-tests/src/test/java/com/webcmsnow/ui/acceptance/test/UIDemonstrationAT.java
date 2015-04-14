package com.opencredo.ui.acceptance.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Run cucumber scenarios tagged as "@ui-demo"
 * Write HTML report out to UIDemonstrationAT folder
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        tags = { "@ui-demo", "~@ignore" },
        format = { "json:target/UIDemonstrationAT.json", "html:target/cucumber-report/UIDemonstrationAT" })
public class UIDemonstrationAT
{
}
