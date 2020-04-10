package com.caoc.test.designMode.adapter;

public class AdapterTest {
	public static void main(String[] args) {
		Phone phone = new Phone();
		VoltageAdapter adapter = new VoltageAdapter();
		phone.setVoltageAdapter(adapter);
		phone.change();
	}
}
