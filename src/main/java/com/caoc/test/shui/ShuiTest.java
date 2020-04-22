package com.caoc.test.shui;

public class ShuiTest {


	public static void main(String[] args) {
		A classA = new A();
		System.out.println(classA.a);



		classA.setA( hello("10"));
		System.out.println(classA.a);

	}


	public static int hello(String hello){
		System.out.println(hello);
		return 5 + Integer.valueOf(hello);
	}




	static class A {
		private int a = 0;

		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}
	}
}
