package com.nasvillanueva.budgettracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by NazIsEvil on 13/12/2015.
 */
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.nasvillanueva.budgettracker")
public class RootConfig {

    /**
     * Registers a PropertySourcesPlaceHolderConfigure so that ${...} will be evaluated on @Value
     * because spring doesn't automatically register a PropertySourcePlaceholderConfigure
     * upon using @PropertySource
     */
    @Bean
    public PropertySourcesPlaceholderConfigurer properties() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
