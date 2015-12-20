package com.nasvillanueva.budgettracker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by NazIsEvil on 13/12/2015.
 */
@EnableWebMvc
@Configuration
@Import(SwaggerConfig.class)
public class WebMvcConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**", "/images/**", "/js/**", "/bower_components/**",
                        "/swagger-ui.html", "/webjars/**")
                .addResourceLocations("/css/", "/images/", "/js/", "/bower_components/",
                        "classpath:/META-INF/resources/", "classpath:/META-INF/resources/webjars/");

        registry.addResourceHandler("/admin_app/**")
                .addResourceLocations("/admin_app/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin/").setViewName("/admin_app/index.html");
        registry.addRedirectViewController("/admin", "/admin/");
    }
}
