package com.caoc.test.proxy;

public class JavaProxyInvocationTest {

	public static void main(String[] args) {

		Hello hello = new HelloImpl();
		DynamicProxy proxy = new DynamicProxy(hello);
		//
		Hello helloProxy2 = proxy.newProxyInstance();
		helloProxy2.sayHello("461");
		helloProxy2.sayHello2("462");

		//cglibProxy
//		CGlibProxyTest cGlibProxy = new CGlibProxyTest();
//		Hello helloProxy = cGlibProxy.getProxy(HelloImpl.class);
//		helloProxy.sayHello(" what");
	}
}
