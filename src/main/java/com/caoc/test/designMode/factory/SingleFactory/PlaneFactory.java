package com.caoc.test.designMode.factory.SingleFactory;

public class PlaneFactory extends VehicleFactory {
	public Moveable create() {
		return new Plane();
	}
}
