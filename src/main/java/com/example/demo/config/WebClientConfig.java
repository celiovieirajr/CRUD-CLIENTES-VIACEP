package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

<<<<<<< HEAD
    @Value("${api.base.url}")
=======
    @Value("${api.base.url.viacep}")
>>>>>>> beaf508c110cf88d88e9acf7758970ce30a29b41
    private String apiBaseUrl;

    @Bean
    public WebClient webClient() {
<<<<<<< HEAD
        return  WebClient.builder().baseUrl(apiBaseUrl).build();
=======
        return  WebClient
                .builder()
                .baseUrl(apiBaseUrl)
                .build();
>>>>>>> beaf508c110cf88d88e9acf7758970ce30a29b41
    }
}
