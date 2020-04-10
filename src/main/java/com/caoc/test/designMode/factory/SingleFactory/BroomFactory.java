package com.caoc.test.designMode.factory.SingleFactory;

public class BroomFactory extends VehicleFactory {
	public Moveable create() {
		return new Broom();
	}
}
