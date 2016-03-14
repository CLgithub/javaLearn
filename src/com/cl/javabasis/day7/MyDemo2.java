package com.cl.javabasis.day7;

public class MyDemo2 {
	public static void main(String[] args) {
		Student stu = new Student(1);
		stu.name="a";//子类对象访问父类非静态成员
		stu.age=12;//子类对象访问父类静态成员
		stu.method1();//子类对象访问父类非静态方法
		stu.method2();//子类对象访问父类静态方法
		
		stu.method2();
		System.out.println(stu);
		new MyDemo2().print();
	}
	
	private void print(){
		System.out.println(super.toString());
		System.out.println(super.getClass());
	}

	
}
