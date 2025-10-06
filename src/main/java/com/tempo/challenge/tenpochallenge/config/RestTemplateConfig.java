package com.tempo.challenge.tenpochallenge.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestTemplateConfig {
    @Bean
    RestTemplate restTemplate(RestTemplateInterceptor restTemplateInterceptor) {
        return new RestTemplateBuilder()
            .connectTimeout(Duration.ofSeconds(2))
            .readTimeout(Duration.ofSeconds(5))
            .interceptors(restTemplateInterceptor)
            .build();
    }
}
