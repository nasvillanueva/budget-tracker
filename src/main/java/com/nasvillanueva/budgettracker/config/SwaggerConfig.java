package com.nasvillanueva.budgettracker.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;


/**
 * Created by jvillanueva on 12/17/15.
 */
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .directModelSubstitute(LocalDateTime.class, String.class)
                .directModelSubstitute(LocalDate.class, String.class)
                .groupName("budget-tracker")
                .pathMapping("/")
                .select()
                .paths(paths()) // and by paths
                .build()
                .apiInfo(apiInfo());
    }

    //Here is an example where we select any api that matches one of these paths
    @SuppressWarnings("unchecked")
    private Predicate<String> paths() {
        return or(
                regex("/api/test.*")
        );
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Budget Tracker REST API",
                "Budget Tracker REST API Documentation.",
                "1.0",
                "API TOS",
                "nasvillanuevait@gmail.com",
                "MIT", //license label
                "" //license url
        );
    }
}
