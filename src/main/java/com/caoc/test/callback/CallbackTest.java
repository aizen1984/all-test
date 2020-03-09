package com.caoc.test.callback;

public class CallbackTest {
	public static void main(String[] args) {
		HaoYiMing haoYiMing = new HaoYiMing();//把郝一鸣同学创造出来（此处应该还需要郝一鸣同学的妈妈）
		Teacher wang = new Teacher(haoYiMing);//然后new一个王老师，将郝一鸣同学作为王老师布置课后作业的对象
		haoYiMing.resoleAnswer(wang);//郝一鸣同学做完作业之后将作业本交给王老师
	}
}
