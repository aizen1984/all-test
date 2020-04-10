package com.caoc.test.designMode.factory;

public class Factory {
	public static Car getCarInstance(String type) {
		Car c = null;
		if ("Benz".equals(type)) {
			c = new Benz();
		}
		if ("Ford".equals(type)) {
			c = new Ford();
		}
		return c;
	}
}
