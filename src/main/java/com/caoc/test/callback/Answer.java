package com.caoc.test.callback;

public class Answer {
	private String name;

	private String banji;

	private String answer;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBanji() {
		return banji;
	}


	public void setBanji(String banji) {
		this.banji = banji;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override


	public String toString() {
		return "Answer [name=" + name + ", banji=" + banji + ", answer=" + answer + "]";
	}

}
