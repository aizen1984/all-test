package com.caoc.test.designMode.decoration;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Food {
	private String foodName;

	public String make() {
		return foodName;
	}
}
