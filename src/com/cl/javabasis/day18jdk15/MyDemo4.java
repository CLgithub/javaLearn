package com.cl.javabasis.day18jdk15;
/*
 jdk1.5新特性之-----可变参数
 
 需求：定义一个函数做加法功能(函数做几个数据的加法功能是不确定的)
 可变参数的格式：
 	数据类型... 变量名
 	
可变参数要注意到细节:
	1.如果一个函数的行参使用上课变参数之后，那么调用该方法的时候可以传递参数，也可以不传递参数
	2.可变参数实际上是一个数组对象。
	3.可变参数必须位于形参的最后一个位置
	4.一个函数最多只能有一个可变参数，因为必须唯一最后一个位置
 * */
public class MyDemo4 {
	public static void main(String[] args) {
		System.out.println(addN("haha",1,23,0));
	}
	
	public static int add(int a,int b) {
		return a+b;
	}
	public static int add(int a,int b,int c) {
		return a+b+c;
	}
	public static int add(int[] arr) {
		int retult=0;
		for(int i:arr){
			retult+=i;
		}
		return retult;
	}
	public static int addN(String name,int... arr) {
//		System.out.println(arr.length);
		
		int retult=0;
		for(int i:arr){
			retult+=i;
		}
		return retult;
	}
}
