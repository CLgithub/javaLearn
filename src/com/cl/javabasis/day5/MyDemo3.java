package com.cl.javabasis.day5;

public class MyDemo3 {
	public static void main(String[] args) {
		Person p1=new Person(4,"a");
		System.out.println(p1);
	}
	
}

class Person{
	private String name;
	private int age;
	
	public Person(int age){
//		this(age, "b");
		this.age=age;
//		System.out.println(this);
	}
	public Person(int age,String name) {
		//构造函数相互调用,只能反正第一行
		this(age);
//		this.age=age;
		this.name=name;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
