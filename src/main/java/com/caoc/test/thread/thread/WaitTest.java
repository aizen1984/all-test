package com.caoc.test.thread.thread;

import org.apache.commons.lang3.RandomUtils;

public class WaitTest {


	public static void main(String[] args) {
		WaitTestLoop loop = new WaitTestLoop();
		loop.start();
	}


	static class WaitTestLoop extends Thread {
		@Override
		public void run() {

			while (true) {
				synchronized (this) {
					try {
						long waitTime = 3000 + 100 * RandomUtils.nextInt(0, 10);
						System.out.println("waitTime->" + waitTime);
						wait(waitTime);
						System.out.println("do ----------");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		}
	}


}
