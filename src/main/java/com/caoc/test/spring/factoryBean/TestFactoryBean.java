package com.caoc.test.spring.factoryBean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactoryBean {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
		FactoryBeanService factoryBeanService = classPathXmlApplicationContext.getBean(FactoryBeanService.class);
		factoryBeanService.testFactoryBean();

	}
}
