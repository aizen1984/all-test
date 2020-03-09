package com.caoc.test.javabasic.future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
public class CompletableFutureTests {
	@Test
	public void testMethod() {

		String[] orders = {"1", "2", "3", "4", "5", "6"};
		List<CompletableFuture<Boolean>> futures = new ArrayList<>();

		Arrays.stream(orders).forEach(id -> {
			try{
				futures.add(submitAsync(id));
			}catch (Exception ex){
				System.out.println(ex);
			}
		});

		futures.stream().forEach(f-> {
			try {
				System.out.println(f.get());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	private static Boolean submit(String order) {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		throw new RuntimeException("抛一个异常" + order);
		return true;
	}

	private static CompletableFuture<Boolean> submitAsync(String order) {
		CompletableFuture<Boolean> future = new CompletableFuture<>();
		new Thread(() -> {
			try {
				Boolean result = submit(order);
				future.complete(result);
			} catch (Exception ex) {
				future.completeExceptionally(ex);
			}
		}).start();
		return future;
	}


}
