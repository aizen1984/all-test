package com.caoc.test.proxy;

public class TestProxy {

	public static void main(String[] args) {
		CGlibProxyTest cGlibProxy = new CGlibProxyTest();
		Hello helloProxy = cGlibProxy.getProxy(HelloImpl.class);
		helloProxy.sayHello(" what");
	}
}
