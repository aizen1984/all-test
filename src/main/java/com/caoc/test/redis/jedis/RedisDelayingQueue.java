package com.caoc.test.redis.jedis;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.type.TypeReference;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Type;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class RedisDelayingQueue<T> {
	static class TaskItem<T> {
		public String id;
		public T msg;
	}

	private Type taskType = new TypeReference<TaskItem<T>>() {
	}.getType();
	private Jedis jedis;
	private String queueKey;

	public RedisDelayingQueue(Type taskType, String queueKey, Jedis jedis) {
		this.taskType = taskType;
		this.queueKey = queueKey;
		this.jedis = jedis;
	}


	/**
	 * 延时5秒
	 * @param msg
	 */
	public void delay(T msg) {
		TaskItem task = new TaskItem();
		task.id = UUID.randomUUID().toString();
		task.msg = msg;
		String s = JSON.toJSONString(task);
		jedis.zadd(queueKey, System.currentTimeMillis() + 5000, s);
		System.out.println("-->添加元素完毕:" + s);
	}

	/**
	 * 延时队列
	 */
	public void loop() {
		while (!Thread.interrupted()) {
			Set<String> values = jedis.zrangeByScore(queueKey, 0, System.currentTimeMillis(), 0, 1);
			if (values.isEmpty()) {
				try {
					System.out.println("空");
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				}
				continue;
			}
			String s = values.iterator().next();
			if (jedis.zrem(queueKey, s) > 0) {
				TaskItem task = JSON.parseObject(s, TaskItem.class);
				this.handMessage((T) task.msg);
			}
			System.out.println("-->删除执行完毕！");
		}
		System.out.println("-->中断完成！");
	}

	public void handMessage(T msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) {
		Jedis jedis = new Jedis();
		RedisDelayingQueue queue = new RedisDelayingQueue(null, "q-demo", jedis);
		Thread producer = new Thread(() -> {
			IntStream.range(0, 10).forEach(i -> queue.delay("codehole" + i));
		});
		Thread consumer = new Thread(() -> {
			queue.loop();
		});

		producer.start();
		consumer.start();

		try {
			producer.join();
//			Thread.sleep(3000);
//			consumer.interrupt();
//			consumer.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}
}
