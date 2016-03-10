package com.cl.javabasis.day8;

public class MyDemo4 {
	public static void main(String[] args) {
		/*
		 思考为什么会这样，原因在于定义一个A类型的对象a（静态全局成员变量和静态方法已经确定要调用A的了（共享区中）），
		把new 出来的B类型的对象装在里面（把索引交给他），而new B()前会先new A()，A中非静态的成员也已加载，
		当调用a的全局成员变量和静态方法时，自然调用的是A的，只有非静态方法才调用的是B的
		*/
		/*
		 new B()时会先new A(),此时A中的成员和静态方法（除了非静态方法外）已经加载到内存，当调用a的成员或方法时，
		 如果B重写了A的非静态方法，就调用B的，否则就调用A的
		 * */
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