package com.caoc.test.thread.thread;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPoolTest {
	static ConnectionPool connectionPool = new ConnectionPool(10);
	static CountDownLatch start = new CountDownLatch(1);

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

	static class ConnectionRunner implements Runnable {

		int count;
		AtomicInteger got;
		AtomicInteger notGot;

		public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
			this.count = count;
			this.got = got;
			this.notGot = notGot;
		}

		@SneakyThrows
		@Override
		public void run() {
			try {
				start.await();
			} catch (InterruptedException e) {
			}
			while (count > 0) {
				Connection connection = connectionPool.fetchConnection(1000);
				if (connection != null) {
					try {
						connection.createStatement();
						connection.commit();
					} finally {
						connectionPool.releaseConnection(connection);
						got.incrementAndGet();
					}
				}
				else{
					notGot.incrementAndGet();
				}
			}
		}
	}







}
