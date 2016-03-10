package com.cl.javabasis.day10;

import java.util.Arrays;

public class MyDemo5 {
	public static void main(String[] args) {
//		byte[] buff=new byte[1024*1024*100];
//		try {
//			Thread.sleep(1000*10);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println(buff);
		
		Throwable throwable=new Throwable("my错误和异常1");
		throwable.printStackTrace();
		Exception exception=new Exception("my异常2");
		exception.printStackTrace();
	}
}
