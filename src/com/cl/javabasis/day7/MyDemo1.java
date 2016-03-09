package com.cl.javabasis.day7;

/**
 * 单例模式
 * 实现方法：构造函数私有化，提供一个public static公共静态方法去获得对象
 * @author L
 * @date 2016年3月9日
 */
public class MyDemo1 {
	public static void main(String[] args) {
		Demo1 demo1 = Demo1.getDemo1();
		demo1.setName("a");
		
		Demo2 demo2=Demo2.getDemo2();
		demo2.setName("");
	}
}

/**
 * 单例模式一：饿汉式
 */
class Demo1 {
	private Demo1() {}
	public static Demo1 getDemo1() {
		return demo1;
	}
	private static final Demo1 demo1 = new Demo1();
	
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}

/**
 * 单例模式二：懒汉式
 */
class Demo2 {
	private Demo2() {}
	public static Demo2 getDemo2() {
		if (demo2 == null) {
			demo2 = new Demo2();
		}
		return demo2;
	}
	private static Demo2 demo2 = null;
	
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
