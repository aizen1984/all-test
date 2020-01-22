package com.caoc.test.spring.bean;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

public class AnnotatedBeanDefinitionParsingDemo {
	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		AnnotatedBeanDefinitionReader beanDefinition = new AnnotatedBeanDefinitionReader(beanFactory);

		beanDefinition.register(AnnotationBeanDefinitionDemo.class);
		AnnotationBeanDefinitionDemo definitionDemo = beanFactory.getBean(AnnotationBeanDefinitionDemo.class);
		System.out.println(definitionDemo);

	}
}
