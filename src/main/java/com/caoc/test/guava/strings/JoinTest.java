package com.caoc.test.guava.strings;

import com.google.common.base.Joiner;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JoinTest {
	public static void main(String[] args) {
		Joiner joiner = Joiner.on("-").skipNulls();
		System.out.println(joiner.join(IntStream.range(1, 10).mapToObj(t -> t).collect(Collectors.toList())));


	}
}
