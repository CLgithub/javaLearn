package com.cl.javabasis.day27reflect;

import java.lang.reflect.Constructor;

import javax.swing.text.html.HTMLEditorKit.Parser;

/*
 如何通过反射对象获取构造方法
 */
public class MyDemo2 {
	public static void main(String[] args) throws Exception {
		//获取到对应的Class对象
		Class clazz1=Class.forName("com.cl.javabasis.day27reflect.Person");
		//通过Class对象获取到对应的构造方法
//		Constructor[] constructors=clazz1.getConstructors();//获取所有public构造方法
//		for(Constructor constructor:constructors){
//			System.out.println(constructor);
//		}
//		Constructor[] constructors=clazz1.getDeclaredConstructors();	//获取所有构造方法，包括private，		Declared（宣告）
//		for(Constructor constructor:constructors){
//			System.out.println(constructor);
//		}
		
//		Constructor constructor=clazz1.getConstructor(int.class,String.class);	//获取单个当构造方法
//		Person person=(Person) constructor.newInstance(111,"小红");		//创建一个对象
//		System.out.println(person);
		
		//获取私有的构造函数
		Constructor constructor2=clazz1.getDeclaredConstructor(null);
		System.out.println(constructor2);
		//暴力反射
		constructor2.setAccessible(true);
		System.out.println(constructor2);
		Person person2=(Person) constructor2.newInstance(null);
		System.out.println(person2);
	}
}
