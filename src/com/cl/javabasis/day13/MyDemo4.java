package com.cl.javabasis.day13;

import java.util.Random;

/**
 * Math 数学类，主要是提供了很多的数学工具给我们使用
 */
public class MyDemo4 {
	public static void main(String[] args) {
//		method1();
		method2();
	}
	
	static void method1(){
//		System.out.println(Math.abs(-3));//绝对值
//		
//		System.out.println(Math.ceil(1.3));//像上取整
//		System.out.println(Math.ceil(-1.3));//像上取整
//		
//		System.out.println(Math.floor(1.3));//向下取整
//		System.out.println(Math.floor(-1.3));//向下取整
//		
//		System.out.println(Math.round(2.4));//四舍五入（+0.5再向左取整）
//		System.out.println(Math.round(2.5));//四舍五入
//		System.out.println(Math.round(-2.4));//四舍五入
//		System.out.println(Math.round(-2.5));//四舍五入
		
		System.out.println(Math.random()*10);//随机数
		//更好用,next……后可以产生各种类型的随机
		Random random=new Random();
		int r=random.nextInt(11);//产生0~10之间的随机数
		int r2=random.nextInt(10)+1;//产生1~9之间的随机数
		System.out.println(r2);
		
		System.out.println(random.nextBoolean());
		
	}
	
	static void method2(){
		Random random=new Random();
		char[] arr={'a','b','c','中','文'};
		StringBuilder sBuilder=new StringBuilder();
		for(int i=0;i<5;i++){
			int index=random.nextInt(arr.length);
			sBuilder.append(arr[index]);
		}
		System.out.println(sBuilder);
	}
}
