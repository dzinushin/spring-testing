package com.example.spring_testing_demo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(SpringJUnitConfigIntegrationTest.Config.class)
//
// @ExtendWith(SpringExtension.class)
// @ContextConfiguration(classes = SpringJUnitConfigTest.Config.class)
public class SpringJUnitConfigIntegrationTest {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void app_context_should_be_not_null() {
        assertNotNull(applicationContext);
        int beanDefinitionCount = applicationContext.getBeanDefinitionCount();
        log.info("beanDefinitionCount: {}",  beanDefinitionCount);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        log.info("beanDefinitionNames: {}", Arrays.toString(beanDefinitionNames));
    }

    static class Config {}
}
