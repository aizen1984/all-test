package com.caoc.test.clazz;

public class ClassFieldTest {
	public static void main(String[] args) {
		User user = new User();
		System.out.println(user.name);
		System.out.println(user.code);
		user.a();
		user.b();
	}

	/**
	 * 静态内部类的成员本类就可以直接访问私有变量
	 * 私有方法等
	 */
	static class User {
		private String name = "hello";
		private String code = "1";
		public String name1 = "hello2";

		public void a() {
			System.out.println("a");

		}

		private void b() {
			System.out.println("b");
		}
	}

}
