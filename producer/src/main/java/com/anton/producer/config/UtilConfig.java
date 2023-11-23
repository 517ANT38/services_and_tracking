package com.anton.producer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class UtilConfig {
    @Bean
    Random r(){
        return new Random();
    }
}
