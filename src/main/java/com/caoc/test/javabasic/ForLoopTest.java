package com.caoc.test.javabasic;

public class ForLoopTest {
	public static void main(String[] args) {

		outloop1:
		for (int i = 0; i < 3; i++) {
			System.out.println("i--------->" + i);
			for (int j = 0; j < 10; j++) {
				System.out.println("j-->" + j);
				if (j == 6) {
//					continue outloop1;
					break  outloop1;
				}
			}
		}
	}
}
