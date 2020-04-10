package com.caoc.test.parameterizedType;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ParameterizedBean {
	List<String> list1;
	List list2;
	Map<String, Long> map1;
	Map map2;
	Map.Entry<Long, Short> map3;


	public static void main(String[] args) {
		Field[] fields = ParameterizedBean.class.getDeclaredFields();
//		Arrays.stream(fields).forEach(field -> {
//					System.out.println(field.getName() + ":" + (field.getGenericType() instanceof ParameterizedType));
//					System.out.println(field.getGenericType().getClass());
//				}
//		);

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
