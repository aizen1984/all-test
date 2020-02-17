package com.caoc.test.classAnlysis;

public class ClassB {

	private int a = 1234;
	static long c = 111;

	public long test(long num) {
		long ret = this.a + num + c;
		return ret;
	}
}
