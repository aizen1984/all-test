package com.caoc.test.aop.domain;

import com.caoc.test.aop.annotation.MyAop;
import com.caoc.test.aop.req.CalReq;

public class MathCalculator {
    @MyAop
	public int div(int i, int j) {
		System.out.println("MathCalculator >> div");
		return i / j;
	}


	public Object div2(CalReq req) {
		System.out.println("MathCalculator >>> div2");
		return req.getId();
	}
}
