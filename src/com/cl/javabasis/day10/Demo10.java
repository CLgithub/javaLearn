package com.cl.javabasis.day10;
/*
异常的处理：
	方式一：捕获处理
	
	方式二：抛出处理
	要注意的细节：
		1.如果一个方法内部抛出了一个编译时异常对象，那么必须要在方法上声明抛出
		2.如果调用了声明抛出编译时异常的方法，那么调用者必须要处理异常
		3.如果一个方法内部抛出了一个异常对象，那么throw语句后面的代码都不会再执行（一个方法遇到了throw关键字，改方法也会马上停止执行）
		4.在一种情况下，只能抛出一种类型的异常对象
		
throw 于 throws 两关键字
	1.throw关键字是用于方法内部，而throws是用于方法声明上
	2.throw关键字是用于方法内部抛出一个异常对象的，而throws关键字是适用在方法声明上声明抛出异常类型的
	3.throw关键字后面只能有一个异常对象，throws后面一次可以声明抛出多种类型的异常
	
何时使用抛出处理，何时使用捕获处理？
	如果需要通知到调用者，你的代码出了问题，那么使用抛出处理
	如果代码时直接与用户打交道，就不应抛，应该捕获
	
*/
public class Demo10 {
	public static void main(String[] args) {
		try {
			int[] arr=null;
			div(4, 0, arr);//调用了一个声明抛出异常的方法
		} catch (Exception e) {
			System.out.println("出现异常了");
			e.printStackTrace();
		}	
	}
	public static void div(int a,int b,int[] arr) throws Exception,NullPointerException{
		if(b==0){
			throw new Exception();	//抛出一个异常
		}else if(arr==null){
			throw new NullPointerException();
		}
		int c=a/b;
		System.out.println("c="+c);
	}
}
