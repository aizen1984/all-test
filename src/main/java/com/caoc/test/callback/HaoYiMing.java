package com.caoc.test.callback;

import lombok.SneakyThrows;

public class HaoYiMing implements Student {

	@SneakyThrows
	@Override
	public void resoleAnswer(Teacher callBack) {
		Answer answer = null;
		Thread.sleep(3000);//郝一鸣同学做了一晚上的作业，十点才做完
		answer = new Answer();
		answer.setName("郝一鸣");
		answer.setBanji("三年级二班");
		answer.setAnswer("锄禾日当午，汗滴禾下土。");
		callBack.tellAnswer(answer);
	}
}
