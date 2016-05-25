package com.cl.javabasis.day10;

/*
异常的体系：
------| Throwable （抛投）所有错误或异常的超类
------------| Error	（错误）错误一般时由于jvm或硬件引发的问题，所以我们一般不会通过代码去处理这个错误的
------------| Exception	（异常）是需要通过代码去处理的
------------------| 编译时异常
------------------| 运行时异常

如何区分错误于异常呢？
	如果程序出现了不正常的信息，如果不正常信息的类名是以error结尾的，那么肯定是一个错误
	如果是以exception结尾的，那么肯定是一个异常

疑问：下面的信息是通过printStackTrace方法打印处理的，那么异常对象是从何而来
	Exception in thread "main" java.lang.ArithmeticException: / by zero
		at com.cl.javabasis.day10.Demo9.div(Demo9.java:26)
		at com.cl.javabasis.day10.Demo9.main(Demo9.java:22)
		
	java虚拟机运行到a／b这个语句的时候，发现b为0，除数为0在现实中是属于不正常的情况，jvm一旦发现了这种不正常的情况，那么jvm就
	马上创建一个对应的异常对象，并且会调用这个异常对象的printStackTrace方法来处理，所以才有这些异常信息
	
异常的处理：
	方式一：捕获处理
			格式：
			try{
				可能发送异常的代码
			}catch(捕获的异常类型 变量名){
				异常的处理方式
			}
		
		捕获处理要注意的细节：
			1.如果try快中代码出现了异常经过处理后，那么try－catch块外面的代码可以正常执行
			2.如果try块中出现了异常的代码，那么在try块中出现异常代码后面的代码是不会执行了
			3.一个try块后面是可以跟多个catch块的，也就是一个try块可以捕获多种异常的
			4.一个try块可以捕获多种异常,但是捕获的异常类型必须从小到大捕获

疑问一：感觉异常处理没多大作用		
	异常处理非常有用，只不过是当前就这样处理而已

疑问二：以后捕获处理，的时候能否就使用Exception即可
	不行，不同的异常需要不同的处理机制
	
	
	方式二：抛出处理

*/
public class Demo9 {
	public static void main(String[] args) {
		//java虚拟机在默认的情况下只能管理64m的内存
//		byte[] buf=new byte[1024*1024*1024*2];
//		System.out.println("Demo9.main()");
		
		int[] arr=null;
		div(4, 2,arr);
	}
	
	public static void div(int a,int b,int[] arr){
		int c = 0;
		try {
			c=a/b;	//jvm一旦发现了这种不正常的情况，那么jvm就会创建一个对应的异常对象
			System.out.println("数组的长度："+arr.length);
		}catch (ArithmeticException e) {
			//处理异常的代码。。。
			System.out.println("异常处理了。。");
			System.out.println("toString:"+e.toString());
		} catch (NullPointerException e) {
			System.out.println("出现了空指针异常");
		}catch(Exception e){	//Exception e=new NullPointerException
			System.out.println("我是急症室，包治百病");
		}
		System.out.println("c="+c);
	}
}
