package com.caoc.test.designMode.proxy;

public class Test {
	public static void main(String[] args) {
		ProxyInterface proxyInterface = new WeddingCompany(new NormalHome());
		proxyInterface.marry();
	}
}
