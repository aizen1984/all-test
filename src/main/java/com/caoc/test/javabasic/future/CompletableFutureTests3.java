package com.caoc.test.javabasic.future;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.map.HashedMap;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;

@Slf4j
public class CompletableFutureTests3 {


	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Map<String, CompletableFuture<Map<String, Object>>> map = new LinkedHashMap<>();
		map.put("runTest1", getMapCompletableFuture(executorService, 1, "runTest1", (t) -> runTest1(t)));
		map.put("runTest2", getMapCompletableFuture(executorService, 1, "runTest2", (t) -> runTest2(t)));
		map.put("runTest3", getMapCompletableFuture(executorService, 1, "runTest3", (t) -> runTest3(t)));


		Map<String, Object> facts = new HashedMap();

		map.forEach((k, v) -> {
			try {
				if (MapUtils.isNotEmpty(v.get(5, TimeUnit.SECONDS)))
					facts.putAll(v.get(1, TimeUnit.SECONDS));
			} catch (TimeoutException e) {
				log.warn("{}调用timeout异常", k, e);
			} catch (Exception e) {
				log.warn("{}调用异常", k, e);
			}
		});

		System.out.println("map is " + facts);
		executorService.shutdown();

	}

	@NotNull
	private static <T, R, U> CompletableFuture<R> getMapCompletableFuture(ExecutorService executorService, T t, U u, Function<T, R> function) {
		return CompletableFuture.supplyAsync(() -> {
			try {
				return function.apply(t);
			} catch (Exception e) {
				log.warn(u + "异常:", e);
				return null;
			}

		}, executorService);
	}

	@SneakyThrows
	public static Map<String, Object> runTest1(Integer i) {

		System.out.println("runTest1 准备开始！！！");
		TimeUnit.SECONDS.sleep(1);
		Map<String, Object> map = new HashMap<>();
		map.put("1", "2");
//		throw new RuntimeException("runTest1异常了");
		return map;


	}

	@SneakyThrows
	public static Map<String, Object> runTest2(Integer i) {

		System.out.println("runTest2 准备开始！！！");
		TimeUnit.SECONDS.sleep(3);
		Map<String, Object> map = new HashMap<>();
		map.put("2", "3");
//		throw new RuntimeException("runTest2异常了");
		return map;


	}

	@SneakyThrows
	public static Map<String, Object> runTest3(Integer i) {

		System.out.println("runTest3 准备开始！！！");
		TimeUnit.SECONDS.sleep(3);
		Map<String, Object> map = new HashMap<>();
		map.put("1", "2");
		throw new RuntimeException("runTest3内部抛出");
//			return map;


	}


}
