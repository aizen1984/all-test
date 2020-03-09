package com.caoc.test.callback;

public class Teacher implements CallBack {
	private Student student;//此处为了简单化将一个学生作为老师布置作业的对象

	public Teacher(Student student) {
		// TODO Auto-generated constructor stub
		this.student = student;
	}

	@Override
	public void tellAnswer(Answer answer) {
		System.out.println(answer.toString());//将学生返回的答案打印出来
	}

	public void askQuestion() {
		//学生回答问题的时候将老师对象作为参数传过去供学生交作业的时候回调，毕竟要知道将作业交给谁嘛
		student.resoleAnswer(this);
	}
}
