package com.caoc.test.thread.thread;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class ThreadState {
	public static void main(String[] args) {
		new Thread(new TimeWaiting(), "TimeWaiting Thread").start();
		new Thread(new Waiting(), "WaitingThread start").start();

		new Thread(new Blocked(), "Blocked-Thread-1").start();
		new Thread(new Blocked(), "Blocked-Thread-2").start();

	}


	static class TimeWaiting implements Runnable {

		@SneakyThrows
		@Override
		public void run() {
			while (true) {
				TimeUnit.SECONDS.sleep(100);
			}
		}
	}

	static class Waiting implements Runnable {
		@SneakyThrows
		@Override
		public void run() {
			while (true) {
				synchronized (Waiting.class) {
					Waiting.class.wait();
				}
			}
		}
	}

	static class Blocked implements Runnable {

		@SneakyThrows
		@Override
		public void run() {
			synchronized (Blocked.class) {
				while (true) {
					TimeUnit.SECONDS.sleep(100);
				}
			}
		}
	}


	static class SleepUtils {
		public static final void second(long seconds) {
			try {
				TimeUnit.SECONDS.sleep(seconds);
			} catch (InterruptedException e) {
			}

		}
	}
}

