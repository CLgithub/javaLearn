package com.cl.javabasis.day7;

import java.lang.reflect.Method;
import java.util.Arrays;

/*
instanceof
比较运算符
检查是否是类的对象
	1：可以判断对象是否是某一个类的实例
	用法
	对象  instanceof 类; 
	
案例
定义一个功能函数，根据传递进来的对象的做不同的事情
	如果是狗让其看家，如果是猫让其抓老鼠
1：定义动物类
2：定义狗类继承动物类
3：定义猫类继承动物类
4：定义功能根据传入的动物，执行具体的功能 
*/
public class MyDemo3 {
	public static void main(String[] args) {
		MyDemo3 demo3=new MyDemo3();
//		demo3.doSomething(new Dog());
//		demo3.doSomething(new Cat());
		
		byte[] bs = new byte[] { 1, 2, 3 };
		int[] is = new int[] { 1, 2, 3 };
		String[] ss = new String[] { "jack", "lucy", "lili" };
		System.out.println(bs instanceof byte[]); // true
		System.out.println(is instanceof int[]); // true
		System.out.println(ss instanceof String[]); // true
//		System.out.println(bs instanceof int[]); // 不可转换的类型
//		System.out.println(is instanceof byte[]); // 不可转换的类型
	}
	// 定义一个功能函数，根据传递进来的对象的做不同的事情
	void doSomething(Animal a) {
		if(a instanceof Dog){
			a.shout();
			a.eat();
			System.out.println("看家");
		}else if (a instanceof Cat) {
			a.shout();
			a.eat();
			System.out.println("捉老鼠");
		}
	}
}

class Animal {
	void shout(){
		System.out.println("我是动物");
	}
	void eat(){
		System.out.println("吃东西");
	}
//	String method1(){
//		System.out.println("功能");
//		return "";
//	}
}
class Cat extends Animal{
	void shout() {
		System.out.println("喵");
	}
	void eat() {
		System.out.println("吃老鼠");
	}
}
class Dog extends Animal{
	void shout() {
		System.out.println("旺");
	}
	void eat() {
		System.out.println("坑骨头");
	}
}