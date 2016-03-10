package com.cl.javabasis.day8;

/**
1.	类实现接口可以通过implements实现，实现接口的时候必须把接口中的所有方法实现,一个类可以实现多个接口。
2.	接口中定义的所有的属性默认是public static final的，即静态常量既然是常量，那么定义的时候必须赋值。
3.	接口中定义的方法不能有方法体。接口中定义的方法默认添加public abstract
4.	有抽象函数的不一定是抽象类，也可以是接口类。
5.	由于接口中的方法默认都是抽象的，所以不能被实例化。
6.	对于接口而言，可以使用子类来实现接口中未被实现的功能函数。
7.	如果实现类中要访问接口中的成员，不能使用super关键字。因为两者之间没有显示的继承关系，况且接口中的成员成员属性是静态的。可以使用接口名直接访问。
8.	接口没有构造方法。

 */
public interface InterFace1 {
	

	
	public static final String name="abc";
	
	void method1();
	
	public abstract void method2();
}
