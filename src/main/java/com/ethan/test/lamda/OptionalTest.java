package com.ethan.test.lamda;

import com.ethan.test.lamda.exampleEntity.Car;
import com.ethan.test.lamda.exampleEntity.Insurance;
import com.ethan.test.lamda.exampleEntity.Person;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import java.util.Properties;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OptionalTest {
	public static void main(String[] args) {
//		Optional<String> s = Optional.empty();
//		Optional<String> s2 = Optional.of(null);
//		Optional<String> s3 = Optional.ofNullable(null);
//		//exception
//		System.out.println(s.orElse("hehe"));
////		System.out.println(s2.orElseGet());
//		System.out.println(s3.get());

		Insurance insurance = new Insurance();
		Optional<Insurance> opt_insurance = Optional.ofNullable(insurance);
		Optional<String> opt_name = opt_insurance.map(x -> x.getName());
		System.out.println(opt_name.orElse("hello"));

		Person person = new Person();
		Optional<Person> optionalPerson = Optional.ofNullable(person);
//		Optional<String> optName = optionalPerson.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName);
//		System.out.println(optName.orElse("heihei"));

		Properties props = new Properties();
		props.setProperty("a", "5");
		props.setProperty("b", "true");
		props.setProperty("c", "-3");

//		Stream stream = Stream.of("hello", "str", "1");

//		fileSteam();
		//生成流
//		Stream.iterate(0, n -> n + 2).limit(100).forEach(System.out::print);

//		Stream.iterate(new int[]{0, 1},
//				t -> new int[]{t[1], t[0] + t[1]}).limit(20).forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));


		IntSupplier fib = new IntSupplier() {
			private int previous = 0;
			private int current = 1;

			@Override
			public int getAsInt() {
				int oldPrevious = this.previous;
				int nextValue = this.previous + this.current;
				this.previous = this.current;
				this.current = nextValue;

				// 0 1--> 1,1--> 1,2-->2 3-->
				// 0-->1 --> 1 -->2 左边的值打印出来
				return oldPrevious;
			}
		};

		IntStream.generate(fib).limit(10).forEach(t -> System.out.print(t + ","));
	}


	/**
	 * 文件流的演示
	 */
	public static void fileSteam() {
		long unique = 0;
		try {
			Stream<String> lines = Files.lines(Paths.get("/Users/caochen/Downloads/settings.xml"),
					Charset.defaultCharset());
//			unique = lines.flatMap(line -> Arrays.stream(line.split(""))).distinct().count();
			//流只能消费一次？
			lines.forEach(System.out::println);
			System.out.println(unique);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	public static Optional<Integer> stringToInt(String s) {
		try {
			return Optional.of(Integer.parseInt(s));
		} catch (Exception e) {
			return Optional.empty();
		}
	}


	public static int readDuration(Properties properties, String name) {
		return Optional.ofNullable(properties.getProperty(name)).
				flatMap(OptionalTest::stringToInt).filter(i -> i > 0).orElse(0);
	}
}
