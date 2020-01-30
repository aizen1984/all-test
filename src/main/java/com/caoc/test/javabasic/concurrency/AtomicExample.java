package com.caoc.test.javabasic.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
	private static AtomicInteger atomicCount = new AtomicInteger();

	private static int count = 0;

	private static void add() {
		atomicCount.incrementAndGet();
		count++;
	}

	public static void main(String[] args) throws InterruptedException {
		final int threadSize = 1000;
		final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < threadSize; i++) {
			executor.execute(() -> {
				add();
				countDownLatch.countDown();
			});
		}
		countDownLatch.await();
		System.out.println("atomicCount: " + atomicCount);
		System.out.println("count: " + count);

//		ThreadPoolUtil.tryReleasePool(executor);
		executor.shutdown();
	}
}
