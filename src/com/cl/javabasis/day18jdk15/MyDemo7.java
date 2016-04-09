package com.cl.javabasis.day18jdk15;
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
 		
 */
public class MyDemo7 {

}
enum Sex{
	man,woman;//枚举值
	
//	public static final Sex man1=new Sex();
//	public static final Sex woman=new Sex();
}
