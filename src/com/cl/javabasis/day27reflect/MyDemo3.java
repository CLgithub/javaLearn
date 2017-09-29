package com.cl.javabasis.day27reflect;

import java.lang.reflect.Method;

/*
 通过反射获取到对应的方法。
 
 方法在反射技术中使用类Method类描述了方法
 */
public class MyDemo3 {
	public static void main(String[] args) throws Exception {
		//获取到对应的Class对象
		Class clazz1=Class.forName("com.cl.javabasis.day27reflect.Person");
		//获取到对应所有公共方法
//		Method[] methods=clazz1.getMethods();//获取所有public方法
//		Method[] methods=clazz1.getDeclaredMethods();//获取到所有的方法，但是不保护父类的方法
//		for(Method method:methods){
//			System.out.println(method);
//		}
		
		
		Person person=new Person(110, "小白");
////		Method methodeat=clazz1.getMethod("eat", int.class);
//		Method methodeat=clazz1.getDeclaredMethod("eat",int.class);
////		methodeat.setAccessible(true);	//对于public方法，不需要进行暴力反射
//		methodeat.invoke(person, 3);	//执行一个方法，第一个参数：方法的调用对象，第二参数：方法所需要的参数
		
		//执行私有方法
//		Method method=clazz1.getDeclaredMethod("sleep", int.class);
//		method.setAccessible(true);		//对于私有方法，需要进行暴力反射
//		method.invoke(null, 7);
		
		//数组类型的class对象
		Method method=clazz1.getMethod("sum", int[].class);
		method.invoke(person, new int[]{1,3,42,4});
	}
}
