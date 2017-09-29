package com.cl.javabasis.day27reflect;

import java.lang.reflect.Field;

/*
 通过反射获取到对应的成员变量
 在反射技术中，使用了Field类描述了成员变量
 */
public class MyDemo4 {
	public static void main(String[] args) throws Exception {
		//获取到对应的Class对象
		Class clazz1=Class.forName("com.cl.javabasis.day27reflect.Person");
		
//		Field[] fields=clazz1.getDeclaredFields();//获取所有的成员变量
//		for(Field field:fields){
//			System.out.println(field);
//		}
		
		Person person=new Person();

		Field field=clazz1.getDeclaredField("id");
		field.setAccessible(true);//设置访问权限可以访问
		field.set(person,13);//给对象设置成员变量，第一个参数：设置该数据的成员变量，第二个参数：属性值
		System.out.println(person);
	}
}
