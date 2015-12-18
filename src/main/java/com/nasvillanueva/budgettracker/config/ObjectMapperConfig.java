package com.nasvillanueva.budgettracker.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by jvillanueva on 12/17/15.
 */
@Configuration
public class ObjectMapperConfig {

    private static final Logger LOG = LoggerFactory.getLogger(ObjectMapperConfig.class);

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    public void initMapping() {
        LOG.debug("Configuring Object Mapper");

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
