package com.caoc.test.mapTest;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();
		map.putIfAbsent("hello", "46");


		map.computeIfAbsent("hello2", k -> "4");
		System.out.println(map);
		map.computeIfAbsent("hello2", k -> "5");
		System.out.println(map);



		map.computeIfPresent("hello3", (k, v) -> 3);
		System.out.println(map);

		map.computeIfAbsent("hello3", (k) -> 3);
		System.out.println(map);


		map.computeIfPresent("hello2", (k, v) -> null);
		System.out.println(map);
	}
}
