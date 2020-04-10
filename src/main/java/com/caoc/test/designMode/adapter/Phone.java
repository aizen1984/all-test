package com.caoc.test.designMode.adapter;

import lombok.Setter;

@Setter
public class Phone {
	public static final int V = -220;
	private VoltageAdapter voltageAdapter;

	public void change() {
		voltageAdapter.changeVoltage();
	}
}
