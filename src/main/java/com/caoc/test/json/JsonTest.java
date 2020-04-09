package com.caoc.test.json;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {
	public static void main(String[] args) {
		Map<String, List<String>> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		map.put("CCICBANK", list);
		System.out.println(JSON.toJSON(map));

	}
}
