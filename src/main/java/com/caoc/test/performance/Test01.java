package com.caoc.test.performance;

public class Test01 {
	public static void main(String[] args) {
		Test01 test01 = new Test01();
		test01.doTest();
	}

	public void doTest() {
		double l;
		long then = System.currentTimeMillis();
//		for (int i = 0; i < 50; i++) {
		l = fibImpl1(5);
//		}
		long now = System.currentTimeMillis();
		System.out.println("Elapsed time: " + (now - then));
	}

	private double fibImpl1(int n) {
//		System.out.println("n-->" + n);
		if (n < 0) throw new IllegalArgumentException("must be > 0");
		if (n == 0) return 0;
		if (n == 1) return 1d;
		double d =fibImpl1(n - 2)+  fibImpl1(n - 1);
		System.out.println( n + "--->" + d);
//		if (Double.isFinite(d)) {
//			throw new ArithmeticException("Overflow");
//		}
		return d;
	}
}
