package com.cl.javabasis.day21other;

import javax.swing.text.html.HTMLEditorKit.Parser;

/*
 练习：
	一家三口每个人都会工作，儿子的工作是画画，母亲的工作是在儿子的基础上做一个增强，不单止可以画画，还可以上涂料，爸爸单工作就是在妈妈基础上增强，就是上画框
 
 */
public class MyDemo3 {
	public static void main(String[] args) {
		P1 p1=new P1();
		Person p2=new P2(p1);
		Person p3=new P3(p2);
//		p1.work();
//		p2.work();
		p3.work();
	}
}

interface Person{
	void work();
}

class P1 implements Person{
	public	void work() {
		System.out.println("画画");
	}
}
class P2 implements Person{
	Person person;
	public P2(Person person) {
		this.person=person;
	}
	@Override
	public void work() {
		person.work();
		System.out.println("上涂料");
	}
}
class P3 implements Person{
	Person person;
	public P3(Person person) {
		this.person=person;
	}
	@Override
	public void work() {
		person.work();
		System.out.println("上画框");
	}
}
