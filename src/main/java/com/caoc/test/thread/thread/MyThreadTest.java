package com.caoc.test.thread.thread;

import lombok.SneakyThrows;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class MyThreadTest {
	public static void main(String[] args) throws InterruptedException {
//		MyThread thread = new MyThread();
//		thread.start();
//
//		Thread thread1 = new Thread(new MyThread2());
//		thread1.start();

//		Thread thread2 = new Thread(new MyThread3());
//		thread2.start();

//		MyThread4 myThread4 = new MyThread4();
//		Thread thread3 = new Thread(myThread4);
//		thread3.start();
//
//		TimeUnit.SECONDS.sleep(2);
////		thread2.interrupt();
//		myThread4.cancel = true;

		
		ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(8);
		Producer producer = new Producer(arrayBlockingQueue);

		Thread thread = new Thread(producer);
		thread.start();
		TimeUnit.SECONDS.sleep(1);

		Consumer consumer = new Consumer(arrayBlockingQueue);
		while (consumer.needMoreNums()) {
			System.out.println(consumer.storage.take() + "被消费了");
		}
		System.out.println("消费者不需要更多数据了);");
		producer.canceled = true;
		System.out.println(producer.canceled);


	}


	static class MyThread extends Thread {
		@Override
		public void run() {
			System.out.println("111");
		}
	}

	static class MyThread2 implements Runnable {
		@Override
		public void run() {
			System.out.println("222");
		}
	}

	static class MyThread3 implements Runnable {

		@Override
		public void run() {
			int count = 0;
			while (!Thread.currentThread().isInterrupted() && count < 10000000) {
				System.out.println("count>>>" + count);
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
					Thread.currentThread().interrupt();
				}
				count++;
			}

		}
	}

	static class MyThread4 implements Runnable {
		public volatile boolean cancel = false;

		@Override
		public void run() {
			int i = 0;
			while (!cancel && i < 100000000) {
				System.out.println("i>>>" + i);
				i++;
			}
		}
	}


	static class Producer implements Runnable {
		BlockingQueue storage;
		private volatile boolean canceled = false;

		public Producer(BlockingQueue blockingQueue) {
			this.storage = blockingQueue;
		}


		@Override
		public void run() {
			int i = 0;
			try {
				while (!canceled && i < 10000000) {

					if (i % 50 == 0) {
						System.out.println("放入仓库>>>" + i);
						storage.put(i);
					}
					i++;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println("生产者运行结束");
			}
		}
	}

	static class Consumer {

		BlockingQueue storage;

		public Consumer(BlockingQueue blockingQueue) {
			this.storage = blockingQueue;
		}

		public boolean needMoreNums() throws InterruptedException {
			if (Math.random() > 0.97) {
				Thread.sleep(100);
				return false;
			}
			return true;
		}
	}


}
