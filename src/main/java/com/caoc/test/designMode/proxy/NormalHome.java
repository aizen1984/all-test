package com.caoc.test.designMode.proxy;

public class NormalHome implements ProxyInterface {
	@Override
	public void marry() {
		System.out.println("我们结婚啦～");
	}
}
