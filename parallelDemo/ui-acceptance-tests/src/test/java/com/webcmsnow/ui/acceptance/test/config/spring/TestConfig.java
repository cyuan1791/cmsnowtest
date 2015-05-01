package com.webcmsnow.ui.acceptance.test.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.webcmsnow.ui.acceptance.test.common.World;
import com.webcmsnow.ui.acceptance.test.config.TestProperties;
import com.webcmsnow.ui.acceptance.test.config.webdriver.SharedDriver;
import com.webcmsnow.ui.acceptance.test.interaction.objects.WebCMSPage;

/**
 * Spring configuration for autowired objects
 */
@Configuration
@PropertySource(value = { "classpath:/props-for-ui-tests.properties" })
public class TestConfig {
    @Bean
    public World world() {
        return new World();
    }

    @Bean
    public SharedDriver driver() throws Exception{
        return new SharedDriver();
    }

    @Bean
    public TestProperties properties() {
        return new TestProperties();
    }

   
    @Bean
    public WebCMSPage webCMSPage() throws Exception{
        return new WebCMSPage(
                properties().getApplicationWebBaseUrl(),
                driver(),
                properties().getSeleniumWaitTimeOutSeconds()
        );
    }
}
