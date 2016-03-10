package com.cl.javabasis.day8;

public class MyDemo4 {
	public static void main(String[] args) {
		A a=new B();
		
		//1.当父类和子类具有相同的静态或非静态成员变量时，在多态下访问的都是父类的成员变量
		System.out.println(a.x);//父
		System.out.println(a.y);//父
		//2.当父类和子类具有相同的非静态方法（就是子类重写父类方法），多态下访问的是子类的成员方法。
		a.method1();//子
		//当父类和子类具有相同的静态方法（就是子类重写父类静态方法），多态下访问的是父类的静态方法。
		a.method2();//父
	}
}
class A{
	String x="父类非静态成员";
	static String y="父类静态成员";
	
	void method1(){
		System.out.println("父类非静态方法");
	}
	
	static void method2(){
		System.out.println("父类静态方法");
	}
}
class B extends A{
	String x="子类非静态成员";
	static String y="子类静态成员";
	
	void method1(){
		System.out.println("子类非静态方法");
	}
	
	static void method2(){
		System.out.println("子类静态方法");
	}
	
}