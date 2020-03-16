package com.caoc.test.proxy;

import org.springframework.stereotype.Component;

@Component
public class HelloImpl implements Hello  {
	@Override
	public void sayHello(String name) {
		System.out.println("Hello" + name);
	}

	@Override
	public void sayHello2(String name) {
		System.out.println("Hello2" + name);
	}
}
