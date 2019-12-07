package com.caoc.test.lamda.test;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class PeriodAmount {
	private Integer period;
	private Integer min;
	private Integer max;

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("roundBai", 100_00);
		map.put("all", 1);
		map.put("int", 100);
		System.out.println(JSON.toJSONString(map));


		System.out.println(3%1);
	}
}
