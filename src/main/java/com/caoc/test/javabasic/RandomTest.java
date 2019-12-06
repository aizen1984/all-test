package com.caoc.test.javabasic;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		RandomTest rt = new RandomTest();
		rt.testRandom();
	}

	public void testRandom() {
		System.out.println("Random不设置种子：");
		for (int i = 0; i < 5; i++) {
			Random random = new Random();
			for (int j = 0; j < 10; j++) {
				System.out.print(" " + random.nextInt(100) + ", ");
			}
			System.out.println("");
		}

		System.out.println("");

		System.out.println("Random设置种子：");
		for (int i = 0; i < 5; i++) {
			Random random = new Random();
			random.setSeed(100);
			for (int j = 0; j < 10; j++) {
				System.out.print(" " + random.nextInt(100) + ", ");
			}
			System.out.println("");
		}
	}
}
