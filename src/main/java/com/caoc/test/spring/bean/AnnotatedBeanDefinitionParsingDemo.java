package com.caoc.test.spring.bean;

import lombok.Data;
import org.springframework.beans.factory.support.*;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

public class AnnotatedBeanDefinitionParsingDemo {
	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		AnnotatedBeanDefinitionReader beanDefinition = new AnnotatedBeanDefinitionReader(beanFactory);
		//AnnotatedBeanDefinitionReader
		beanDefinition.register(AnnotationBeanDefinitionDemo.class);
		AnnotationBeanDefinitionDemo definitionDemo = beanFactory.getBean(AnnotationBeanDefinitionDemo.class);
		System.out.println(definitionDemo);

		//BeanDefinitionBuilder
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
		builder.addPropertyValue("userName", "caoc").addPropertyValue("userId", "1");
		//带名字注册
		beanFactory.registerBeanDefinition("user", builder.getBeanDefinition());
		//不带名字注册
		BeanDefinitionReaderUtils.registerWithGeneratedName(builder.getBeanDefinition(), beanFactory);

		beanFactory.getBeansOfType(User.class);
	}

	@Data
	public static class User {
		private String userName;
		private String userId;
	}



}
