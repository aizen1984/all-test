package com.caoc.test.lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		IntStream.range(0, 20).forEach(i -> {
			list.add(i);
		});

		Optional optional = list.stream().filter(x -> {
			System.out.println(x);
			if (x < 5) {
				return false;
			}
			return true;

		}).filter(x -> {
			System.out.println(x);
			return true;
		}).findFirst();

		//true的留下
		System.out.println(list.stream().filter(i -> i < 10).collect(Collectors.toList()));

		if (!optional.isPresent()) {
			System.out.println("啥也没找到");
		}


//		IntStream.range(0,10).forEach(x->{
//			System.out.println(x);
//			if(x==4){
//				return;
//			}
//		});
//		System.out.println("完事");
	}


}
