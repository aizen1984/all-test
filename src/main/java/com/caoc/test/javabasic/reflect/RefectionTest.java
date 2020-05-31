package com.caoc.test.javabasic.reflect;

import lombok.SneakyThrows;
import org.testng.collections.Lists;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RefectionTest<T> extends ReflectParent implements Serializable {

	private int temp1;
	private T temp2;
	public Map map;
	private Map<String, Object> map2;

	@Deprecated
	private void test() {
		System.out.println("test");
	}

	public void test2() {
		System.out.println("test2");
	}

	@SneakyThrows
	public static void main(String[] args) {
		System.out.println("=======getDeclaredFields");
		Arrays.stream(RefectionTest.class.getDeclaredFields()).forEach(System.out::println);
		System.out.println("=======getFields");
		Arrays.stream(RefectionTest.class.getFields()).forEach(System.out::println);

		Class clazz = RefectionTest.class;
		List listAllFields = Lists.newArrayList();
		while (clazz != null) {
			listAllFields.addAll(Arrays.asList(clazz.getDeclaredFields()));
			clazz = clazz.getSuperclass();
		}
		System.out.println("=======getAllFields");
		listAllFields.forEach(System.out::println);

		System.out.println("=======getGenericInterfaces");
		System.out.println(RefectionTest.class.getGenericInterfaces());
		System.out.println(RefectionTest.class.getGenericSuperclass());
		System.out.println(RefectionTest.class.getTypeParameters());


		Field field = RefectionTest.class.getDeclaredField("map2");
		System.out.println(field.getGenericType());
		System.out.println(((ParameterizedTypeImpl) field.getGenericType()).getActualTypeArguments());
		System.out.println(field.getType());

		Method method = RefectionTest.class.getDeclaredMethod("test", null);
		System.out.println(method.getDeclaredAnnotations()[0]);
		RefectionTest refectionTest = new RefectionTest();
		method.invoke(refectionTest, null);




	}


}
