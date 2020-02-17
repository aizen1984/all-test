package com.caoc.test.thread.thread;

import java.util.concurrent.TimeUnit;

public class WrongResult {
	private static volatile int count = 0;

	public static void main(String[] args) throws InterruptedException {
		Runnable r1 = () -> {
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName()+"处理");
				count++;
			}
		};

		Thread t = new Thread(r1);
		Thread t2 = new Thread(r1);


		t.start();
		t2.start();

//		t.join();
//		t2.join();
		TimeUnit.SECONDS.sleep(3);
		;
		System.out.println("处理完成："+ count);

	}
}
