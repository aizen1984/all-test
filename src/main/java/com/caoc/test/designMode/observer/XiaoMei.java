package com.caoc.test.designMode.observer;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class XiaoMei {
	List<Person> list = new ArrayList();

	public void addPerson(Person person) {
		list.add(person);
	}

	public void notifyPerson() {
		for (Person person : list) {
			person.getMessage("你们过来吧，谁先过来谁就能陪我一起玩儿游戏!");
		}
	}
}
