package com.caoc.test.thread.thread;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class Interrupted {
	@SneakyThrows
	public static void main(String[] args) {
		Thread sleepThread = new Thread(new SleepRunner(), "SleepRunner");
		sleepThread.setDaemon(true);

		Thread busyThread = new Thread(new BusyRunner(), "BusyRunner");
		busyThread.setDaemon(true);

		sleepThread.start();
		busyThread.start();


		TimeUnit.SECONDS.sleep(5);


		sleepThread.interrupt();
		busyThread.interrupt();

		System.out.println("Sleep Thread is interrupted is " + sleepThread.isInterrupted());
		System.out.println("Busy Thread is interrupted is " + busyThread.isInterrupted());

		TimeUnit.SECONDS.sleep(2);

	}

	static class SleepRunner implements Runnable {
		@SneakyThrows
		@Override
		public void run() {
			while (true) {
				TimeUnit.SECONDS.sleep(10);
			}
		}
	}

	static class BusyRunner implements Runnable {

		@Override
		public void run() {
			while (true) {

			}
		}
	}
}
