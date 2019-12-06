package com.caoc.test.thread.thread;

import java.util.concurrent.TimeUnit;

public class ThreadTest {

	static final Object obj = new Object();
	private static boolean flag = false;

	public static void main(String[] args) {
		Thread consume = new Thread(new Consume(), "consume");
		Thread produce = new Thread(new Produce(), "produce");

		consume.start();
		try {
			TimeUnit.SECONDS.sleep(1);
			produce.start();

			produce.join();
			consume.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("主线程结束");


	}


	//生产者线程
	static class Produce implements Runnable {
		@Override
		public void run() {
			synchronized (obj) {
				System.out.println("进入生产者线程");
				System.out.println("生产");

				try {
					//模拟生产
					TimeUnit.SECONDS.sleep(2);
					flag = true;
					obj.notify();
					//模拟其他情况
					TimeUnit.SECONDS.sleep(1);
					System.out.println("退出生产者线程");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}
	}


	static class Consume implements Runnable {

		@Override
		public void run() {
			synchronized (obj) {
				System.out.println("进入消费线程");
				System.out.println("wait flag 1:" + flag);
				while (!flag) {
					System.out.println("还没生产，进入等待");
					try {
						obj.wait();
						System.out.println("等待结束");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("wait flag 2:" + flag);
				System.out.println("消费");
				System.out.println("退出消费者线程");
			}

		}
	}
}

