package com.caoc.test.jvm.test;

public class BitMoveTest {
	public static void main(String[] args) {
		int a = 5;
		for (int i = 0; i < 32; i++) {
			//0x80000000 代表最高位为1的数字
			int t = (a & 0x80000000 >>> i) >>> (31 - i);
			System.out.print(t);
		}
		System.out.println();
	}
}
