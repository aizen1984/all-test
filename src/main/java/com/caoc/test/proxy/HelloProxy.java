package com.caoc.test.proxy;

public class HelloProxy implements Hello {

	private Hello hello;

	public HelloProxy() {
		hello = new HelloImpl();
	}

	@Override
	public void sayHello(String name) {
//		before();
		hello.sayHello(name);
//		after();
	}

	private void after() {
		System.out.println("after￿￿￿￿");
	}

	private void before() {
		System.out.println("before");
	}

	public static void main(String[] args) {
		Hello helloProxy = new HelloProxy();
		helloProxy.sayHello("caoc");
	}
}
