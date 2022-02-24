package com.example.seatabusinessservice.config;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Autowired
    XidRequestInterceptor xidRequestInterceptor;

    @Bean
    RestTemplate restTemplate() {
        var restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(xidRequestInterceptor));

        return restTemplate;
    }
}
