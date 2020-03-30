package com.caoc.test.javabasic.basicType;

import java.util.HashMap;
import java.util.Map;

public class BooleanTest {
	public static void main(String[] args) {
		Boolean a = null;
		System.out.println(a instanceof Boolean);

		Map<String, Boolean> map = new HashMap<>();

		map.put("1", false);

		System.out.println(map.get("1") instanceof Boolean ? map.get("1").booleanValue() : false);

	}
}
