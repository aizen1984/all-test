package com.caoc.test.proxy;

public class TestProxy {

	public static void main(String[] args) {

		Hello hello = new HelloImpl();
		DynamicProxy proxy = new DynamicProxy(hello);
		Hello helloProxy2 = proxy.getProxy();
		helloProxy2.sayHello("dynamicProxy");

		//cglibProxy
//		CGlibProxyTest cGlibProxy = new CGlibProxyTest();
//		Hello helloProxy = cGlibProxy.getProxy(HelloImpl.class);
//		helloProxy.sayHello(" what");
	}
}
