package com.caoc.test.javabasic.future;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTests2 {
	ExecutorService executor = Executors.newFixedThreadPool(3);

	@Test
	public void testMethod() throws InterruptedException {
		String[] orders = {"1", "2", "3", "4", "5", "6"};
		Arrays.stream(orders).forEach(id ->
				CompletableFuture.supplyAsync(() -> submit(id), executor).exceptionally(e -> {
					System.out.println(e);
					throw new RuntimeException(e);
//			return false;
				}));

		TimeUnit.SECONDS.sleep(1);

		executor.shutdown();
		while (!executor.isTerminated()) {
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static Boolean submit(String order) {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("抛一个异常" + order);
	}
}
