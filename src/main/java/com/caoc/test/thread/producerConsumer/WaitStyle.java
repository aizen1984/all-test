package com.caoc.test.thread.producerConsumer;

import lombok.AllArgsConstructor;

import java.util.concurrent.TimeUnit;

public class WaitStyle {
	public static void main(String[] args) throws InterruptedException {
		MyBlockingQueue myBlockingQueue = new MyBlockingQueue(10);
		Producer producer = new Producer(myBlockingQueue);
		Consumer consumer = new Consumer(myBlockingQueue);
		new Thread(producer).start();
		TimeUnit.SECONDS.sleep(2);
		new Thread(consumer).start();

	}

	@AllArgsConstructor
	static
	class Producer implements Runnable {

		private MyBlockingQueue storage;

		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				System.out.println("put >>>" + i);
				storage.put(new Object());
			}
		}
	}

	@AllArgsConstructor
	static
	class Consumer implements Runnable {

		private MyBlockingQueue storage;

		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				System.out.println("take >>>" + i);
				storage.take();
			}
		}
	}


}
