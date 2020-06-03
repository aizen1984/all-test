package com.caoc.test.thread.thread;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class Join {


	@SneakyThrows
	public static void main(String[] args) {
		Thread previous = Thread.currentThread();
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new Domino(previous), String.valueOf(i));
			thread.start();
			previous = thread;
		}
		TimeUnit.SECONDS.sleep(3);
		System.out.println("preparing end");
	}


	static class Domino implements Runnable {

		private Thread thread;

		public Domino(Thread thread) {
			this.thread = thread;
		}

		@Override
		public void run() {
			try {
				thread.join();
			} catch (InterruptedException e) {

			}
			System.out.println(Thread.currentThread().getName() + " terminate.");
		}
	}
}

