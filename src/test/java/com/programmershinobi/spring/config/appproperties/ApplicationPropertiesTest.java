package com.programmershinobi.spring.config.appproperties;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@Slf4j
@SpringBootTest(classes = ApplicationPropertiesTest.TestApplication.class)
public class ApplicationPropertiesTest {

    @Autowired
    private Environment environment;

    @Test
    void testApplicationProperties() {
        String applicationName = environment.getProperty("application.name");
        Assertions.assertEquals("Belajar Spring Boot", applicationName);
        log.info(applicationName);
    }

    @SpringBootApplication
    public static class TestApplication {

    }

}
