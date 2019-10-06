package com.ethan.test.javabasic.threadTest;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FutureTest {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		List<Future> futureList = IntStream.rangeClosed(1, 10).boxed()
				.map(t -> executorService.submit(() -> doLongTimeAction(t))).collect(Collectors.toList());
		futureList.stream().forEach(t -> {
			try {
				System.out.println("future.get()-->" + t.get(3, TimeUnit.SECONDS));
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				e.printStackTrace();
			}
		});
		executorService.shutdown();




	}


	public static int doLongTimeAction(int i) {

		try {
			System.out.println("i" + i + "-->start");
			TimeUnit.SECONDS.sleep(3);
			System.out.println("job" + i + "done some long time");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return i;
	}
}
