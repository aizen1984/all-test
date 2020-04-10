package com.caoc.test.designMode.decoration;

public class DecorationTest {
	public static void main(String[] args) {
		Food food = new Bread(new Vegetable(new Cream(new Food("香肠"))));
		System.out.println(food.make());
	}
}
