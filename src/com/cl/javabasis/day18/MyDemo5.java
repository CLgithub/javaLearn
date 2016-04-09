package com.cl.javabasis.day18;

import java.util.ArrayList;

/*
 jdk1.5新特性之-----自动装箱与自动拆箱
 java是面向对象的语言，如果事务都可以使用类进行描述，sun就使用了
 一下类描述java中的八种基本数据类型数据
 	
 	基本数据类型		包装类型
 	byte			Byte
 	shot			Shot
 	int				Integer
 	long			Long
 	
 	float			Float
 	double			Double
 	
 	boolean			boolean
 	
 	char 			Character
 	
 基本数据类型数据有了包装类型的好处：
 	1.让基本数据类型
 */
public class MyDemo5 {
	public static void main(String[] args) {
		//把字符串转换成对应的数字
		String str="12";
		int i=Integer.parseInt(str);
		System.out.println(i+1);
		//把数字转换成对应的字符串
//		System.out.println(i+"");
		System.out.println("把数字转换成对应的字符串："+Integer.toString(i));
		
		//把整数转换成对应的进制形式
		System.out.println("10的二进制："+Integer.toBinaryString(10));
		System.out.println("10的八进制："+Integer.toOctalString(10));
		System.out.println("10的十六进制："+Integer.toHexString(10));
		
		//可以把字符串当成对应的进制数据帮你转换
		String data="10";
		int i1=Integer.parseInt(data,2);
		System.out.println(i1);
		
		//集合：集合是可以存储任意对象数据类型数据的容器
		/*ArrayList list=new ArrayList();
		list.add(1);//
		list.add(2);
		list.add(3);*/
		
		//自动装箱：自动把java中的基本数据类型数据转换成对象数据类型数据
		int a=10;	//基本数据类型
		Integer b=a;	//integer数据类型数据
		
		//自动拆箱：把引用数据类型的数据转换成基本数据类型的数据
		Integer b1=3;
		int b2=b1;
		
		//应用数据类型
		Integer e=128;
		Integer f=128;
		System.out.println("同一个对象吗"+(e==f));//Integer类内部维护了一个缓冲数字，该缓冲数组存储了-128到127这些数据在数组中，
		//如果你存的数据在其中，就在这些数据中取数据
		MyClass m=new MyClass();
		MyClass m2=new MyClass();
		System.out.println(m.equals(m2));
		System.out.println(m==m2);
		
	}
}
class MyClass{
	
}