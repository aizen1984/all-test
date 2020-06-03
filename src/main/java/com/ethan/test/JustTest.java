package com.ethan.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.collections.MapUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JustTest {
	public static void main(String[] args) {
		List<A> list = new ArrayList<>();
		list.add(new A("1"));
		list.add(new A("2"));

		Map<String, A> afterLimitAsset = list.stream()
				.filter(x -> x.equals("4"))
				.collect(Collectors.toMap(x -> x.getId(), y -> y, (x, y) -> y));


		System.out.println(afterLimitAsset);

		System.out.println(MapUtils.isEmpty(afterLimitAsset));
	}


	@Data
	@AllArgsConstructor
	static class A {
		private String id;

	}
}
