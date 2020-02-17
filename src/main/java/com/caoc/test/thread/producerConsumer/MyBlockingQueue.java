package com.caoc.test.thread.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue {
	private Queue queue;
	private int max = 16;
	private ReentrantLock lock = new ReentrantLock();
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();


	public MyBlockingQueue(int size) {
		this.max = size;
		this.queue = new LinkedList();
	}

	public void put(Object o) {
		lock.lock();
		try {
			while (queue.size() == max) {
				notFull.await();
			}
			queue.add(o);
			notEmpty.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public Object take() {
		lock.lock();
		try {
			while (queue.size() == 0) {
				notEmpty.await();
			}
			Object item = queue.remove();
			notFull.signalAll();
			return item;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			lock.unlock();
		}
	}


	public synchronized void put2(Object obj) throws InterruptedException {
		while (queue.size() == max) {
			wait();
		}
		queue.add(obj);
	}

	public synchronized void take2() throws InterruptedException {
		while (queue.size() == 0) {
			wait();
		}
		System.out.println(queue.remove());
		notifyAll();
	}

}
