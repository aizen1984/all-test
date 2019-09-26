package com.ethan.test.redis.jedis;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Type;
import java.util.UUID;

public class RedisDelayingQueue<T> {
	static class TaskItem<T> {
		public String id;
		public T msg;
	}
	private Type taskType = new TypeReference<TaskItem<T>>(){}.getType();
	private Jedis jedis;
	private String queueKey;

	public RedisDelayingQueue(Type taskType, String queueKey) {
		this.taskType = taskType;
		this.queueKey = queueKey;
	}


	public void delay(T msg) {
		TaskItem task = new TaskItem();
		task.id = UUID.randomUUID().toString();
		task.msg = msg;
		String s = JSON.toJSONString(task);
		jedis.zadd(queueKey, System.currentTimeMillis() + 5000,s);
	}
}
