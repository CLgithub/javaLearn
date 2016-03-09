package com.cl.javabasis.day8;

import java.util.Arrays;

public class MyDemo2 {
	public static void main(String[] args) {
		//基本数据类型交换
		int a=10;
		int b=20;
		System.out.println("交换前a＝"+a+",b="+b);
		change1(a, b);
		System.out.println("交换后a＝"+a+",b="+b);
		//数组交换
		int[] arr ={1,2,3,4};
		System.out.println("交换前"+Arrays.toString(arr));
		change2(arr,1, 3);
		System.out.println("交换后"+Arrays.toString(arr));
		//对象的值交换
		TestC testC=new TestC(1);
		System.out.println("交换前"+testC.x);
		change3(testC, 20);
		System.out.println("交换后"+testC.x);
		//字符串的值交换
		String str="abc";
		System.out.println("交换前"+str);
		change4(str, "def");
		System.out.println("交换后"+str);
		
	}

	

	public static void change1(int a,int b){
		a=a^b;
		b=a^b;
		a=a^b;
	}
	
	public static void change2(int[] arr,int a,int b){
		arr[a]=arr[a]^arr[b];
		arr[b]=arr[a]^arr[b];
		arr[a]=arr[a]^arr[b];
	}
	
	public static void change3(TestC testC,int a){
		testC.x=a;
	}
	
	public static void change4(String str, String string) {
		str=string;
	}
}

class TestC{
	int x;
	
	public TestC(int x) {
		this.x=x;
	}
}