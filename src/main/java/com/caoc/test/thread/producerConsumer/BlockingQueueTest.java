package com.caoc.test.thread.producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest {
	public static void main(String[] args) {
		BlockingQueue<Object> queue = new ArrayBlockingQueue<>(10);

		Runnable producer = () -> {
			while (true) {
				try {
					TimeUnit.SECONDS.sleep(2);
					queue.put(new Object());
					System.out.println("放入了1个!");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(producer).start();
		new Thread(producer).start();

		Runnable consumer = () -> {
			while (true) {
				try {
					TimeUnit.SECONDS.sleep(1);
					queue.take();
					System.out.println("消费了一个!");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};


		new Thread(consumer).start();
		new Thread(consumer).start();


	}
}
