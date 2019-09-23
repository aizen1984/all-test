package com.ethan.test.enumTest;

public enum OrderTypeEnum {
	NORMAL("普通订单"),
	PARENT("父订单"),
	CHILD("子订单");

	private String description;

	OrderTypeEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
