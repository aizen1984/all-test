package com.caoc.test.parameterizedType;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

import java.lang.reflect.*;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ParameterizedBean extends ParentFields {
	List<String> list1;
	List list2;
	Map<String, Long> map1;
	Map map2;
	Map.Entry<Long, Short> map3;

	private void test() {
		System.out.println("test");
	}

	public void test1() {
		System.out.println("test1");
	}

	private String test2() {
		System.out.println("test2");
		return "test2";
	}


	public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
		Field[] fields = ParameterizedBean.class.getDeclaredFields();
		Field[] fields1 = FieldUtils.getAllFields(ParameterizedBean.class);
		//		Arrays.stream(fields).forEach(field -> {
		//					System.out.println(field.getName() + ":" + (field.getGenericType() instanceof ParameterizedType));
		//					System.out.println(field.getGenericType().getClass());
		//				}
		//		);
		Object object = ParameterizedBean.class.newInstance();
		MethodUtils.invokeExactMethod(object, "test1");

		Method method = ParameterizedBean.class.getDeclaredMethod("test");
		method.setAccessible(true);
		method.invoke(object, null);

		for (Field f : fields) {
			if (f.getGenericType() instanceof ParameterizedType) {
				ParameterizedType parameterizedType = (ParameterizedType) f.getGenericType();
				System.out.println("raw类型" + parameterizedType.getRawType().getTypeName());

				if (parameterizedType.getOwnerType() == null) {
					System.out.println("ownType:" + null);
				} else {
					System.out.println("ownType:" + parameterizedType.getOwnerType().getTypeName());
				}


				//				System.out.println(parameterizedType.getClass());
				Type[] types = parameterizedType.getActualTypeArguments();
				for (Type t : types) {
					System.out.println("类型" + t.getTypeName());

				}
			}
		}
	}
}
