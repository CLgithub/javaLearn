package com.cl.javabasis.day7;

class Person {
	static{
		System.out.println("父类静态初始化代码块！");
	}
	{System.out.println("父类初始化代码块！");}
	public Person() {
		System.out.println("父类无参构造函数！");
	}
	public Person(int i) {
		System.out.println("父类有参构造函数！");
	}
	
	String name;
	static int age;
	
	void method1(){
		System.out.println("父类非静态方法");
	}
	
	static void method2(){
		System.out.println("父类静态方法");
	}

}

class Student extends Person {
	static{
		System.out.println("子类静态初始化代码块！");
	}
	{System.out.println("子类初始化代码块！");}
	public Student() {
		System.out.println("子类无参构造函数！");
	}
	public Student(int i) {
//		this();
		super(1);//调用父类有参构造函数
		System.out.println("子类有参构造函数！");
	}

	@Override
	public String toString() {
		return "Student [name=" + super.name + ",age=" + this.age + "]";
	}

	@Override
	void method1() {
		super.age=1;
		System.out.println("子类非静态方法");
	}
	
	
	
	
	
}

