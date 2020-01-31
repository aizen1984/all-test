package com.caoc.test.aop.domain;

import com.caoc.test.aop.annotation.MyAop;

public class MathCalculator {
    @MyAop
	public int div(int i, int j) {
		System.out.println("MathCalculator >> div");
		return i / j;
	}
}
