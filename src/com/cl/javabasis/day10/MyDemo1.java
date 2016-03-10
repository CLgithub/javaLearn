package com.cl.javabasis.day10;

public class MyDemo1 {
	public static void main(String[] args) {
		new MyDemo1().show();
	}
	private String count="外部类成员";
	
	private void show(){
		System.out.println("外部类访问非静态内部类非静态成员："+new Inner().count);
		System.out.println("外部类访问静态内部类静态成员："+new Inner2().count);
		System.out.println("外部类访问静态内部类静态成员："+Inner2.count);
		System.out.println("外部类访问静态内部类非静态成员："+new Inner2().count2);
//		new Inner().print();
		
//		System.out.println(new MyDemo1.Inner().count);
	}
	
	//定义一个非静态内部类
	private class Inner{
		private String count="内部类成员";
	}
	//定义一个非静态内部类
	private static class Inner2{
		private static String count="静态内部类静态成员";
		private String count2="静态内部类非静态成员";
	}
}
