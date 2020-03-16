package com.caoc.test.aop.shuhe.base;

public enum TransResultStatus {
	SUCCESS("成功"),
	FAILED("失败"),
	UNKNOWN("未知");

	private final String desc;

	 TransResultStatus(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return this.desc;
	}
}
