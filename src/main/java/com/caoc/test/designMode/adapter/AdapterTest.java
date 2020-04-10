package com.caoc.test.designMode.adapter;

import lombok.Setter;

public class AdapterTest {
	public static void main(String[] args) {
		Phone phone = new Phone();
		VoltageAdapter adapter = new VoltageAdapter();
		phone.setVoltageAdapter(adapter);
		phone.change();
	}

	@Setter
	static class Phone {
		public static final int V = -220;
		private VoltageAdapter voltageAdapter;

		public void change() {
			voltageAdapter.changeVoltage();
		}
	}

	static class VoltageAdapter {
		public void changeVoltage() {
			System.out.println("正在充电...");
			System.out.println("原始电压：" + Phone.V + "V");
			System.out.println("经过变压器转换之后的电压:" + (Phone.V - 200) + "V");
		}
	}

}
