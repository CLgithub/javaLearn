package com.cl.javabasis.day8;

/**
 抽象类可以没有抽象方法（java.awt.*的类就是这样子操作的）。
抽象类可以继承普通类与抽象类。
抽象类不能直接使用类名创建实例，但是有构造方法，构造方法是让子类进行初始化。
抽象类一定有构造方法。
abstract与其他修饰符的关系:
	final与abstract不能共存:
		final:它的作用  修饰类代表不可以继承  修饰方法不可重写
		abstract修饰类就是用来被继承的，修饰方法就是用来被重写的。
	static static修饰的方法可以用类名调用，
		 对于abstract修饰的方法没有具体的方法实现，所有不能直接调用，
		也就是说不可以与static共存。
	private
		private修饰的只能在本类中使用，
		abstract方法是用来被子类进行重写的，有矛盾
		所有不能共存. 
 */
public class MyDemo1 {
	public static void main(String[] args) {
		new Class2();
	}
}

abstract class Class1{
	
	//抽象类可以有构造方法，主要为了初始化抽象类中的属性。通常由子类实现。
	public Class1() {
		System.out.println("抽象类的构造方法");
	}
	abstract void method1();
}

class Class2 extends Class1{
	void method1() {
	}
}
