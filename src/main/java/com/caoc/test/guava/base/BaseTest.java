package com.caoc.test.guava.base;

import com.google.common.base.CaseFormat;

public class BaseTest {
	public static void main(String[] args) {
		System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "x_y_z"));
	}
}
