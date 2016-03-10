package com.cl.javabasis.day10;

/**
成员内部类(成员属性、成员方法)特点: 
1.私有的成员内部类
	特点：不能在其他类中直接创建内部类对象来访问
2. 静态的成员内部类
	特点：如果内部类中包含有静态成员，那么java规定内部类必须声明为静的
	访问静态内部类的形式：
	Demo.Inner3 inner3=new Demo.Inner3();
 */
public class MyDemo2 {
	public static void main(String[] args) {
		Demo.Inner inner=new Demo().new Inner();
//		Demo.Inner2 inner2=new Demo().new Inner2();//private的其他类不能访问
		Demo.Inner3 inner3=new Demo.Inner3();//访问一个类内部的静态类
		
	}
}
class Demo{
	private void show(){
		System.out.println("外部类访问非静态内部类非静态成员："+new Inner().count);
	}
	//定义一个public非静态内部类
	public class Inner{
		private String count="aaa";
	}

	// 定义一个private非静态内部类
	private class Inner2 {
		private String count = "bbb";
	}
	
	//定义一个public静态的内部类
	public static class Inner3{
		public String count0="ccc";
		public static String count="ccc";
	}
}
