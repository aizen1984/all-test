package com.caoc.test.annoationTest.conditionTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConditionTest {
	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ConditionTest.class,args);


		Boolean aBooleanWelcomeController = configurableApplicationContext.containsBean("welcomeController");
		if (!aBooleanWelcomeController) {
			System.out.println("        welcomeController init fail");
		} else {
			WelcomeController welcomeController = (WelcomeController) configurableApplicationContext.getBean("welcomeController");
			System.out.println("        welcomeController init Success");
		}


		Boolean aBooleanAmazonTest = configurableApplicationContext.containsBeanDefinition("amazonTest");
		if (!aBooleanAmazonTest) {
			System.out.println("        amazonTest init fail");
		} else {
			AmazonTest amazonTest = (AmazonTest) configurableApplicationContext.getBean("amazonTest");
			System.out.println("        amazonTest init Success");
		}
	}
}
