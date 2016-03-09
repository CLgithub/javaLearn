package com.cl.javabasis.day7;
/*
 * 思考
	1：为什么子类一定要访问父类的构造函数呢
		子类继承了父类的属性，如果要使用父类的属性必须初始化，创建子类对象，
		必须先初始化父类属性，所以必须调用父类的构造方法。
	2：为什么调用父类无参的构造函数
		设计java语言之时，只知道编译器会默认添加无参的构造函数，有参的无法确定。
		但是可以通过super关键字显式调用父类指定构造函数。
	3：为什么super()this()语句要放在构造函数的第一行
		子类可能会用到父类的属性，所以必须先初始化父类。
		
		结合MyDemo2看效果
 * */
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

