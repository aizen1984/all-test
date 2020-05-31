package com.caoc.test.mapTest;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();
		map.putIfAbsent("hello", "firstValue");

		map.putIfAbsent("hello", "changeValue");
		map.computeIfPresent("hello",(k,v)->v+"1");
		map.computeIfAbsent("hello2", k -> "hello2的Value");
		System.out.println("============1==============");
		System.out.println(map);

		map.computeIfAbsent("hello2", k -> "5");
		System.out.println("============2==============");
		System.out.println(map);



		map.computeIfPresent("hello2", (k, v) -> 3);
		System.out.println("============3==============");
		System.out.println(map);

		map.computeIfAbsent("hello3", (k) -> 3);
		System.out.println("============4==============");
		System.out.println(map);


		map.computeIfPresent("hello2", (k, v) -> null);
		System.out.println(map);
	}
}
