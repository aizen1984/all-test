package com.caoc.test.aop.domain;

public class MathCalculator {

	public int div(int i, int j) {
		System.out.println("MathCalculator >> div");
		return i / j;
	}
}
