package com.caoc.test.designMode.SignleMode;

import lombok.NoArgsConstructor;

/**
 * 双重检查模式
 */
@NoArgsConstructor
public class Singleton5 {
	private volatile static Singleton5 INSTANCE;

	public static Singleton5 getInstance() {
		if (INSTANCE == null) {
			synchronized (Singleton5.class) {
				if (INSTANCE == null) {
					INSTANCE = new Singleton5();
				}
			}
		}
		return INSTANCE;
	}

}
