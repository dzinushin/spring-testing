package com.example.spring_testing_demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(SpringJUnitConfigIntegrationTest.Config.class)
//
// @ExtendWith(SpringExtension.class)
// @ContextConfiguration(classes = SpringJUnitConfigTest.Config.class)
public class SpringJUnitConfigIntegrationTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void app_context_should_be_not_null() {
        assertNotNull(applicationContext);
        int beanDefinitionCount = applicationContext.getBeanDefinitionCount();
        System.out.println("beanDefinitionCount: "+ beanDefinitionCount);
    }

    static class Config {}
}
