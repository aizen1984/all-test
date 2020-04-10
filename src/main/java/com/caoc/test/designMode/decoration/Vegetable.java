package com.caoc.test.designMode.decoration;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Vegetable extends Food {
	private Food basicFood;

	public String make() {
		return basicFood.make() + "蔬菜";
	}
}
