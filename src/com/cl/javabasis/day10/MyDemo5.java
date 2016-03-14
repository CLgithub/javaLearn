package com.cl.javabasis.day10;

import java.util.Arrays;

public class MyDemo5 {
	public static void main(String[] args) {
		int i=method3();
		System.out.println(i);
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
	//try里面有格return语句，finally里面也会执行，在teturn前执行
	public static int method3() {
		try {
			method4();
			return -1;
		} catch (Throwable e) {
			e.printStackTrace();
		}finally {
			System.out.println("最后都要执行");
		}
		return 1;
	}
	
	public static void method4() throws Exception{
		throw new Exception("我的异常");//手动抛出异常
	}
}
