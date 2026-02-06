package com.programmershinobi.spring.config.messagesource;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

public class MessageSourceTest {

    private ApplicationContext applicationContext;

    private MessageSource messageSource;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(TestApplication.class);
        messageSource = applicationContext.getBean(MessageSource.class);
    }

    @Test
    void testDefaultLocale() {
        String message = messageSource.getMessage("hello", new Object[]{"Faqih"}, Locale.ENGLISH);
        Assertions.assertEquals("Hello Faqih", message);
    }

    @Test
    void testIndonesianLocale() {
        String message = messageSource.getMessage("hello", new Object[]{"Faqih"}, new Locale("id"));
        Assertions.assertEquals("Halo Faqih", message);
    }

    @SpringBootApplication
    public static class TestApplication {

        @Bean
        public MessageSource messageSource(){
            ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
            messageSource.setBasenames("my");
            return messageSource;
        }

    }

}
