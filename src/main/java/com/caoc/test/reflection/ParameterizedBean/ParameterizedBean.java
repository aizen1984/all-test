package com.caoc.test.reflection.ParameterizedBean;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ParameterizedBean {
	List<String> list1;
	List list2;
	Map<String, Long> map1;
	Map map2;
	Map.Entry<Long, Short> map3;

	public static void main(String[] args) {
		Field[] fields = ParameterizedBean.class.getDeclaredFields();
		Arrays.stream(fields).forEach(f -> {
			ParameterizedType parameterizedType = (ParameterizedType) f.getGenericType();
			Type[] types = parameterizedType.getActualTypeArguments();
			System.out.println(types);
			//System.out.println(f.getName() + "-" + (f.getGenericType() instanceof ParameterizedType));
		});
	}
}
