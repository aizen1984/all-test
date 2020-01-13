package com.caoc.test.proxy.spring;


import com.caoc.test.proxy.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client2 {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		Hello hello = (Hello) applicationContext.getBean("helloImpl");
		hello.sayHello("jack");
	}
}
