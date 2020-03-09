package com.caoc.test.javabasic.future;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.map.HashedMap;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.function.Function;

@Slf4j
public class CompletableFutureTests3 {


	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		List<CompletableFuture<Map<String, Object>>> list = new ArrayList<>();
		Integer i = new Integer(1);

		CompletableFuture<Map<String, Object>> c1 = getMapCompletableFuture(executorService, i, "runTest1", (t) -> runTest1(t));
		CompletableFuture<Map<String, Object>> c2 = getMapCompletableFuture(executorService, i, "runTest2", (t) -> runTest2(t));
		CompletableFuture<Map<String, Object>> c3 = getMapCompletableFuture(executorService, i, "runTest3", (t) -> runTest3(t));




		list.add(c1);
		list.add(c2);
		list.add(c3);


		Map<String, Object> facts = new HashedMap();
		try {
			list.forEach(mapCompletableFuture -> {
				try {
					facts.putAll(mapCompletableFuture.get(1, TimeUnit.SECONDS));
				} catch (TimeoutException e) {
					log.warn("timeout异常", e);
				} catch (Exception e) {
					log.warn("其他异常", e);
				}
			});
		} catch (Exception e) {
			System.out.println("取数异常");
		}
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
		map.put("1", "2");
		throw new RuntimeException("runTest2异常了");
//			return map;


	}

	@SneakyThrows
	public static Map<String, Object> runTest3(Integer i) {

		System.out.println("runTest3 准备开始！！！");
		TimeUnit.SECONDS.sleep(3);
		Map<String, Object> map = new HashMap<>();
		map.put("1", "2");
		throw new RuntimeException("runTest3 异常了");
//			return map;


	}


}
