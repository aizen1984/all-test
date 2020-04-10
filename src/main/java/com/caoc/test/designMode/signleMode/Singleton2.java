package com.caoc.test.designMode.signleMode;

import lombok.NoArgsConstructor;

/**
 * 饿汗模式
 */
@NoArgsConstructor
public class Singleton2 {
	private static Singleton2 instance = new Singleton2();

	public static Singleton2 getInstance() {
		return instance;
	}



}
