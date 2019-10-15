package com.caoc.test.redis.jedis;

import redis.clients.jedis.Jedis;

import java.util.concurrent.ThreadLocalRandom;

public class PftTest {
	public static void main(String[] args) {
		Jedis jedis = new Jedis();
		for (int i = 0; i < 100000; i++) {
			jedis.pfadd("codehole", "user" + i);
			long total = jedis.pfcount("codehole");
			if (total != i + 1) {
				System.out.printf("%d %d\n", total, i + 1);
				break;
			}
		}
		jedis.close();

		for (int i = 1000; i < 100000; i += 100) { Experiment exp = new Experiment(i); exp.work();
			exp.debug();
		}

	}

	static class BitKeeper {
		private int maxbits;

		public void random() {
			long value = ThreadLocalRandom.current().nextLong(2L << 32);
			int bits = lowZeros(value);
			if (bits > this.maxbits) {
				this.maxbits = bits;
			}
		}

		private int lowZeros(long value) {
			int i = 1;
			for (; i < 32; i++) {
				if (value >> i << i != value) {
					break;
				}
			}
			return i - 1;
		}
	}

	static class Experiment {
		private int n;
		private BitKeeper keeper;

		public Experiment(int n) {
			this.n = n;
			this.keeper = new BitKeeper();
		}

		public void work() {
			for (int i = 0; i < n; i++) {
				this.keeper.random();
			}
		}

		public void debug() {
			System.out.printf("%d %.2f %d\n", this.n, Math.log(this.n) / Math.log(2), this.keeper.maxbits);
		}
	}


}
