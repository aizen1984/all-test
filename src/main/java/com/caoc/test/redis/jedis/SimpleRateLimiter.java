package com.caoc.test.redis.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

public class SimpleRateLimiter {
	private Jedis jedis;

	public SimpleRateLimiter(Jedis jedis) {
		this.jedis = jedis;
	}

	public boolean isActionAllowed(String userId, String actionKey, int period, int maxCount) {
		String key = String.format("his：%s:%s", userId, actionKey);
		long nowTs = System.currentTimeMillis();
		//pipeline是干嘛的
		Pipeline pipeline = jedis.pipelined();
		pipeline.multi();
		pipeline.zadd(key, nowTs, "" + nowTs);
		pipeline.zrangeByScore(key, 0, nowTs - period * 1_000);
		Response<Long> count = pipeline.zcard(key);
		pipeline.expire(key, period + 1);
		pipeline.exec();
		pipeline.close();
		return count.get() <= maxCount;
	}

	public static void main(String[] args) {
		Jedis jedis = new Jedis();
		SimpleRateLimiter limiter = new SimpleRateLimiter(jedis);
		for (int i = 0; i < 20; i++) {
			System.out.println(
					limiter.isActionAllowed("laoqian", "reply", 60, 5));
		}
	}

}
