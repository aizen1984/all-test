package com.caoc.test.thread.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPoolTest {
	static ConnectionPool connectionPool = new ConnectionPool(10);
	static CountDownLatch countDownLatch = new CountDownLatch(1);

	static CountDownLatch end;

	public static void main(String[] args) {
		int threadCount = 10;
		end = new CountDownLatch(threadCount);

		int count = 20;

		AtomicInteger got = new AtomicInteger();
		AtomicInteger notGot = new AtomicInteger();

		for (int i = 0; i < threadCount; i++) {
//			Thread thread = new Thread(new ConnectionR)
		}


	}

}
