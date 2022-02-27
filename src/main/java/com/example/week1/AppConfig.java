package com.example.week1;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean //can only be  used with methods
    public RestTemplate createRestTemplate(){
        //to build resttemplate
        return new RestTemplateBuilder().build();
    }

}