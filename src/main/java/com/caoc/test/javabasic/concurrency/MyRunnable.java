package com.caoc.test.javabasic.concurrency;

import lombok.Getter;

import java.util.concurrent.TimeUnit;

public class MyRunnable implements Runnable {

	private Foo foo = new Foo();

	public static void main(String[] args) {
		MyRunnable runnable = new MyRunnable();
		Thread a = new Thread(runnable, "a-");
		Thread b = new Thread(runnable, "b-");
		a.start();
		b.start();
	}

	public int fix(int y) {
		return foo.fix(y);
	}


	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			// read load 100
			// use assign
			// store write

			this.fix(30);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ":当前的foo对象x值= " + foo.getX());
		}
	}

	@Getter
	static class Foo {
		private volatile int x = 100;

		public int fix(int y) {
			x = x - y;
			return x;
		}

	}
}
