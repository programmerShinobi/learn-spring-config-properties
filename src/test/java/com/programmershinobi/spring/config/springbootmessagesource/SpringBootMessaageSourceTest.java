package com.programmershinobi.spring.config.springbootmessagesource;

import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

@SpringBootTest(classes = SpringBootMessaageSourceTest.TestApplication.class)
public class SpringBootMessaageSourceTest {

    @Autowired
    private  TestApplication.SampleSource sampleSource;

    @Test
    void testHelloFaqih() {
        Assertions.assertEquals("Hello Faqih", sampleSource.helloFaqih(Locale.ENGLISH));
        Assertions.assertEquals("Halo Faqih", sampleSource.helloFaqih(new Locale("id")));
    }

    @SpringBootApplication
    public static class TestApplication {

        @Component
        public static class SampleSource implements MessageSourceAware {

            @Setter
            private MessageSource messageSource;

            public String helloFaqih(Locale locale) {
                return messageSource.getMessage("hello", new Object[]{"Faqih"}, locale);
            }

        }

    }

}
