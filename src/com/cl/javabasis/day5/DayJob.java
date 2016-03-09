package com.cl.javabasis.day5;

/**
1.新建一个类文件，然后在main方法里面，使用new ，新建出来，再打印这个对象
2.使用类来描述一个人，（姓名，年龄，性别，出生日期），
	使用new 可以告诉计算机，新建不同的人。
3.在上面的类中，新建一个方法，这个方法要访问全局的变量，
	 并且方法里面有局部变量，这个局部变量和全局变量的名字相同。
	 打印出这个局部变量。
4.在上面例子中为添加一个私有变量，为这个私有变量
	 添加一个get和set的方法，如：setXxx(String xxx) , getXxxx();
	注意：get set方法很重要，以后学的框架都是基于这种格式
5.为上面的类添加 无参数构造器， 有参数构造器， 并且调用它们的构造器。
6.为上面的累添加初始化块和静态的初始化块，并且测试执行的顺序
	 构造器和初始化块哪个先执行？//初始块
	 静态初始化块与初始化块哪个先执行？//什么叫静态初始化块

方法：
1.学会如何使用类文件去描述身边的事务
2.学会在类文件里面定义属性方法（public ,private)有何区别要知道
3.学会编写get ,set方法，
4.学会重新无参数的构造器，和定义有参数的构造器
5.学会使用静态初始化块和初始化块

 */
public class DayJob {
	public static void main(String[] args) {
		PersonA personA1=new PersonA();
//		PersonA personA2=new PersonA(20);
//		personA1.method1();
	}
}

class PersonA {
	private String name;
	private int age;
	
	void method1(){
		int age = 18;
		System.out.println(this.age);
		System.out.println(age);
	}
	
	//无参构造函数
	public PersonA() {
		System.out.println("无参构造函数");
	}
	//有参构造函数
	public PersonA(int age){
		System.out.println("有参构造函数");
	}
	//初始化代码块,即构造代码块
	{
		System.out.println("初始化代码块");
	}
	//静态的初始化块
	static{
		System.out.println("静态的初始化块");
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}


