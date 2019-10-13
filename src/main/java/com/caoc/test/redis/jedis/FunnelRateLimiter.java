package com.caoc.test.redis.jedis;

import java.util.HashMap;
import java.util.Map;

public class FunnelRateLimiter {
	static class Funnel {
		int capacity;
		float leakingRate;
		int leftQuota;
		long leakingTs;

		public Funnel(int capacity, float leakingRate) {
			this.capacity = capacity;
			this.leakingRate = leakingRate;
			this.leftQuota = capacity;
			this.leakingTs = System.currentTimeMillis();
		}

		void makeSpace() {
			long nowTs = System.currentTimeMillis();
			long deltaTs = nowTs - leakingTs;
			System.out.print(" deltaTs-->" + deltaTs);
			int deltaQuota = (int) (deltaTs * leakingRate);
			System.out.print(" deltaQuota-->" + deltaQuota);
			if (deltaQuota < 0) {
				this.leftQuota = capacity;
				this.leakingTs = nowTs;
				return;
			}
			if (deltaQuota < 1) {
				return;
			}
			this.leftQuota += deltaQuota;
			this.leakingTs = nowTs;
			if (leftQuota > capacity) {
				leftQuota = capacity;
			}
		}

		boolean watering(int quota) {
			makeSpace();
			System.out.print(" leftQuota-->"+leftQuota);
			if (leftQuota > quota) {
				this.leftQuota -= quota;

				return true;
			}
			return false;
		}
	}

	private Map<String, Funnel> funnels = new HashMap<>();


	public boolean isActionAllowed(String userId, String actionKey, int capacity, float leakingRate) {
		String key = String.format("%s:%s", userId, actionKey);
		Funnel funnel = funnels.get(key);
		if (funnel == null) {
			funnel = new Funnel(capacity, leakingRate);
			funnels.put(key, funnel);
		}
		return funnel.watering(1);
	}

	public static void main(String[] args) {
		FunnelRateLimiter funnelRateLimiter = new FunnelRateLimiter();

		for (int i = 0; i < 200; i++) {
			System.out.println("  "+
					funnelRateLimiter.isActionAllowed("caoc", "key", 100, (float) 0.5));
		}
	}
}
