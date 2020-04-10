package com.caoc.test.designMode.signleMode;

import lombok.NoArgsConstructor;

/**
 * 懒汉模式
 */
@NoArgsConstructor
public class Signleton1 {
	private static Signleton1 instance;

	public static synchronized Signleton1 getInstance() {
		if (instance == null) {
			instance = new Signleton1();
		}
		return instance;
	}


}
