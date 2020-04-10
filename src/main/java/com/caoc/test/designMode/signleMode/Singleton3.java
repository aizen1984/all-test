package com.caoc.test.designMode.signleMode;

import lombok.NoArgsConstructor;

/**
 * 静态内部类模式
 */
@NoArgsConstructor
public class Singleton3 {
	private static class Singleton3Holder {
		private static final Singleton3 INSTANCE = new Singleton3();
	}

	public static Singleton3 getInstance() {
		return Singleton3Holder.INSTANCE;
	}


}
