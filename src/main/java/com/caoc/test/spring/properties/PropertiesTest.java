package com.caoc.test.spring.properties;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("com.caoc.test.spring.properties")
@Configuration
@PropertySource(value = "classpath:application.properties")
public class PropertiesTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		applicationContext.register(PropertiesTest.class);
		applicationContext.refresh();

		EnablePropertiesConfiguration bean = applicationContext.getBean(EnablePropertiesConfiguration.class);
		System.out.println(bean.getPropertiesCaoc());
	}
}
