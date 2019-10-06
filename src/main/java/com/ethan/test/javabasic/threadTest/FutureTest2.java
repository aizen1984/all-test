package com.ethan.test.javabasic.threadTest;

import java.util.concurrent.*;

public class FutureTest2 {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Future<Integer> future = executorService.submit(() -> {
			System.out.println("正在执行子任务");
			TimeUnit.SECONDS.sleep(2);
			return 1000;
		});
		executorService.shutdown();
		System.out.println("主进程正在进行");

//		try {
//			TimeUnit.SECONDS.sleep(2);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		try {
			System.out.println("task运行结果:" + future.get());
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		} catch (ExecutionException ex) {
			ex.printStackTrace();
		}

		System.out.println("所有线程执行完毕");

	}
}
