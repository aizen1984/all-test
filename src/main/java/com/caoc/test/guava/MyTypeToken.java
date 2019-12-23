package com.caoc.test.guava;

import lombok.Getter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Getter
public abstract class MyTypeToken<T> {
	private final Type type;

	public MyTypeToken() {
		Type genericSuperclass = getClass().getGenericSuperclass();
		if (genericSuperclass instanceof Class) {
			throw new RuntimeException("Missing type parameter.");
		}
		ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
		Type[] types = parameterizedType.getActualTypeArguments();
		type = types[0];
	}

	public static void main(String[] args) {
		MyTypeToken<String> sToken = new MyTypeToken<String>() {

		};
		System.out.println(sToken.getType());
	}
}
