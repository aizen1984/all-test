package com.caoc.test.designMode.factory;

public class FactoryTest {
	public static void main(String[] args) {
		Car c = Factory.getCarInstance("Ford");
		c.run();
		c.stop();
	}
}
