package com.cl.javabasis.day10;

public class MyDemo5 {
	public static void main(String[] args) {
		method2();
	}
	
	public static void method1(){
		byte[] buf=new byte[1024*1024*1024];//osx下可以达到1G
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println(buf);
	}
	
	public static void method2(){
		Throwable throwable=new Throwable("想吐。。。");
		System.out.println(throwable.toString());// 输出该异常的类名
		System.out.println(throwable.getMessage()); // 输出异常的信息
		throwable.printStackTrace();// 打印栈信息
	}
}
