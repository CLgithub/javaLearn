package com.cl.javabasis.day10;

/*
异常：
	我们java程序也会出现某些不正常的情况，这些不正常的情况我们就统称为异常
	
异常的体系：
------| Throwable （抛投）所有错误或异常的超类
------------| Error	（错误）
------------| Exception	（异常）
------------------| 编译时异常
------------------| 运行时异常

Throwable类：
常用的方法：
	toString()			//返回一个throwable的简短描述，（返回当前异常对象的完整类名＋病态信息）
	getMessage()		//返回的是创建throwable传入的字符信息
	printStackTrace()		//打印异常的栈信息
	
*/
public class Demo8 {
	public static void main(String[] args) {
		//创建类一个Throwable对象
//		Throwable throwable=new Throwable("头晕，感冒");
//		String info = throwable.toString();
//		String message = throwable.getMessage();
//		
//		System.out.println("toString:"+info);	//java.lang.Throwable
//		System.out.println("message:"+message);
		
		test();
	}
	
	public static void test(){
		Throwable throwable=new Throwable("xx病");
		throwable.printStackTrace();
	}
}
