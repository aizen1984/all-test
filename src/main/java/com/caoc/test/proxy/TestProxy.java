package com.caoc.test.proxy;

public class TestProxy {

	public static void main(String[] args) {
		CGlibProxy cGlibProxy = new CGlibProxy();
		Hello helloProxy = cGlibProxy.getProxy(HelloImpl.class);
		helloProxy.sayHello(" what");
	}
}
