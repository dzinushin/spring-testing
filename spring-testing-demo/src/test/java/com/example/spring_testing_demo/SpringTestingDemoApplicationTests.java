package com.example.spring_testing_demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootTest
class SpringTestingDemoApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(SpringTestingDemoApplicationTests.class);

	@Autowired
	ApplicationContext applicationContext;

	@Test
	void contextLoads() {
	}


	@Test
	void inspect_application_context() {
		int beanDefinitionCount = applicationContext.getBeanDefinitionCount();
		log.info("beanDefinitionCount: {}",  beanDefinitionCount);

		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		log.info("beanDefinitionNames: {}", Arrays.toString(beanDefinitionNames));
	}

	@Test
	void inject_spring_env_in_test_method(@Autowired  Environment environment) {
		Assertions.assertNotNull(environment);
	}
}
