package com.caoc.test.jvm.statics;

public class InitializationITest {

	private static int a;

	static {
		a = 1;
		b = 1;
	}

	private static int b;

	public static void main(String[] args) {
		System.out.println("a:" + a);
		System.out.println("b:" + b);
	}
}
