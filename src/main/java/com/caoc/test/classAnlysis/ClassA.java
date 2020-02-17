package com.caoc.test.classAnlysis;

public class ClassA {

	ClassB classB = new ClassB();

	/**
	 * 前面我们提到，类的初始化发生在类加载阶段，那对象都有哪些创建方式呢？除了我们常用的 new，还有下面这些方式：
	 *
	 * 	使用 Class 的 newInstance 方法。
	 *
	 * 	使用 Constructor 类的 newInstance 方法。
	 *
	 * 	反序列化。
	 *
	 * 	使用 Object 的 clone 方法。
	 *
	 * 	其中，后面两种方式没有调用到构造函数
	 */


	public static void main(String[] args) {

		ClassA classA = new ClassA();
		long num = 321;
		long ret = classA.classB.test(num);
		System.out.println(ret);
	}


}

