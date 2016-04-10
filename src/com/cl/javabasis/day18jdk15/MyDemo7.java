package com.cl.javabasis.day18jdk15;

import com.cl.javabasis.day11.Test1;

/*
 问题： 某些方法接收到数据必须是固定范围内的，
 枚举：
 枚举类的定义格式：
 	enum 类名{
 		
 	}
枚举要注意的细节：
	1.枚举也是一个特殊的类
	2.枚举值默认的修饰符是public static final 
	3.枚举值的数据类型是枚举值所属类的数据类型,枚举值是指向了本类的对象的
 	4.枚举类的构造方法默认的修饰符是private
 	5.枚举类可以定义自己的成员变量和成员函数
 	6.枚举类可以自定义构造函数，但是必须是private
 	7.枚举类可以存在抽象的方法，但是枚举值必须要实现抽象的方法
 	8.枚举值必须要位于枚举类的第一个语句。
 	
 */
public class MyDemo7 {
	public static void main(String[] args) {
		Sex sex=Sex.man;
		System.out.println(sex.getValue());
	}
}
enum Sex{
	man("男") {
		public void test1() {
			System.out.println("男人在跑");
		}
	},woman("女") {
		public void test1() {
			System.out.println("女人在跑");
		}
	};//枚举值
//	public static final Sex man1=new Sex();
//	public static final Sex woman=new Sex();
	
	String value;//成员变量
	//成员函数
	public String getValue(){
		return value;
	}
	//构造函数
	private Sex(String value) {
		this.value = value;
	}
	
	public abstract void test1();
	
}
