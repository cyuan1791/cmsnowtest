package com.webcmsnow.ui.acceptance.test.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 * Used to retrieve properties and make them available to tests
 */
public class TestProperties {
    @Autowired
    private Environment environment;

    public String getApplicationBaseUrl() {
        return environment.getProperty("ui.acceptance.test.application.base.url");
    }

    public String getApplicationWebBaseUrl() {
        return environment.getProperty("ui.acceptance.test.application.webbase.url");
    }
    
    public int getSeleniumWaitTimeOutSeconds() {
        return environment.getProperty("ui.acceptance.test.selenium.wait.timeout.seconds", Integer.class, 10);
    }
   public static void main(String[] args) throws Exception
    {
    	TestProperties tp = new TestProperties();
        System.out.println(tp.getApplicationBaseUrl());
    }
   
}
