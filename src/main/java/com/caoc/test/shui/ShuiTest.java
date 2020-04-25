package com.caoc.test.shui;

import com.google.common.base.Strings;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.*;

public class ShuiTest {


	public ShuiTest() {
	}

	public static void main(String[] args) throws ClassNotFoundException {
//		A classA = new A();
//		System.out.println(classA.a);
//
//
//		classA.setA(hello("10"));
//		System.out.println(classA.a);

		Class clazz = Class.forName("com.caoc.test.shui.ShuiTest");
		Method[] methods = clazz.getDeclaredMethods();
		Arrays.stream(methods).forEach(x -> {
			System.out.println(x.getName());
			System.out.println(x.getParameterTypes());
			System.out.println(x.getReturnType());
			System.out.println(x.getAnnotatedReturnType());
			System.out.println(x.getAnnotatedParameterTypes());
			System.out.println("=============================");
		});

		long num = 911121222;
		System.out.println("num:" + Strings.padStart(Long.toString(num),6,'0'));



	}

	public static <T> T getLong(T t) {
		return null;
	}


	@Shui("hello world")
	public static int hello(String hello) {
		System.out.println(hello);
		return 5 + Integer.valueOf(hello);
	}


	public Map<String, Object> hello2(String hello, List<String> list) {
		System.out.println("hello2 已经被调用");
		return null;
	}


	static class A extends ShuiTest implements Serializable {
		private int a = 0;

		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}
	}
}
