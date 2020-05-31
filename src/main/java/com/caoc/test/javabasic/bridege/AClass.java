package com.caoc.test.javabasic.bridege;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AClass implements SupperClass<String> {
	@Override
	public void method(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		AClass aClass = new AClass();
		Method method = AClass.class.getMethod("method", String.class);
		method.invoke(aClass, "string");
		System.out.println(method.isBridge());

		method = AClass.class.getMethod("method", Object.class);
		method.invoke(aClass, "object");
		System.out.println(method.isBridge());
	}
}
