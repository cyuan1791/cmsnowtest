package com.opencredo.api.acceptance.test.config.spring;

import com.opencredo.api.acceptance.test.common.World;
import com.opencredo.api.acceptance.test.config.TestProperties;
import com.opencredo.api.acceptance.test.interaction.objects.GithubApi;
import com.opencredo.api.acceptance.test.interaction.objects.GithubStatusApi;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Spring configuration for autowired objects
 */
@Configuration
@PropertySource(value = { "classpath:/props-for-api-tests.properties" })
public class TestConfig {
    @Bean
    public World world() {
        return new World();
    }

    @Bean
    public TestProperties properties() {
        return new TestProperties();
    }

    @Bean
    public GithubApi githubApi() {
        return new GithubApi(properties().getGithubApiUrl());
    }

    @Bean
    public GithubStatusApi githubStatus() {
        return new GithubStatusApi(properties().getGithubStatusApiUrl());
    }

    @Bean
    public HttpClient httpClient() {
        return HttpClientBuilder.create().build();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient()));
    }
}
