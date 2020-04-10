package com.caoc.test.designMode.decoration;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Bread extends Food {
	private Food basicFood;
	public String make() {
		return basicFood.make() + "面包";
	}
}
