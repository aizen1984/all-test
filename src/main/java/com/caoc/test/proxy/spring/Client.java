package com.caoc.test.proxy.spring;

import com.caoc.test.proxy.Hello;
import com.caoc.test.proxy.HelloImpl;
import org.springframework.aop.framework.ProxyFactory;

public class Client {
	public static void main(String[] args) {
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(new HelloImpl());
//		proxyFactory.addAdvice(new GreetingAfterAdvice());
//		proxyFactory.addAdvice(new GreetingBeforeAdvice());
		proxyFactory.addAdvice(new GreetingAroundAdvice());
		Hello hello = (Hello) proxyFactory.getProxy();
		hello.sayHello("-->a");
	}
}
