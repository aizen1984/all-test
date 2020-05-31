package com.caoc.test.guava.base;

import com.google.common.base.CaseFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {
	public static void main(String[] args) {
		System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "x_y_z"));

		int i = 0;
		System.out.println(++i);

		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));


	}
}
