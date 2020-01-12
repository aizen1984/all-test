package com.caoc.test.proxy;

public class HelloImpl implements Hello  {
	@Override
	public void sayHello(String name) {
		System.out.println("Hello" + name);
	}
}
