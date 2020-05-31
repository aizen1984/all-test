package com.caoc.test.lamda.optional;

import java.util.Optional;

public class OptionalTest {
	public static void main(String[] args) {
		Optional<String> optionalS = Optional.ofNullable(null);
		System.out.println(optionalS.map(s -> s + "hello").orElse("empty"));

		Optional<String> optionalS2 = Optional.ofNullable("11");
		optionalS2.map(s -> s + "hello").filter(s -> s.contains("hello")).ifPresent(t -> System.out.println(t));


	}


}
