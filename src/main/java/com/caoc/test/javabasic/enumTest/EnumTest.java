package com.caoc.test.javabasic.enumTest;

public class EnumTest {
	public static void main(String[] args) {
		System.out.println(OrderTypeEnum.CHILD.getDescription());


		System.out.println(BankEnum.valueOf("BQD_V2").getClass().getSimpleName());
	}
}