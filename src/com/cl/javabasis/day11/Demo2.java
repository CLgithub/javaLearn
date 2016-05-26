package com.cl.javabasis.day11;

/*
异常体系：
-----| Throwable 所有错误或异常的超类
----------| Error(错误)
----------| Exception	异常一般通过代码处理

---------------| 运行时异常：如果一个方法内部，那么方法上可以声明，也可以不声明，调用者可以处理，也可以不处理
---------------| 编译时异常（非运行时异常，受检异常）如果一个方法内部抛出了一个编译时异常，那么方法上必须要声明，调用者也必须要处理

运行时异常：runTimeException和runTimeException的子类
编译时异常：除了运行时异常的异常

问什么要设计区分编译时异常和运行时异常
	运行时异常都是可以通过程序员良好的编程习惯去避免的，所以java编译器没有严格要求


*/
public class Demo2 {
	public static void main(String[] args) {
		div(4, 0);
//		Object object=new Object();
//		object.wait();
	}
	
	public static void div(int a,int b){
		if(b==0){
			throw new ArithmeticException();//抛出一个runtimeException，可以声明，也可以不声明
		}
		int c=a/b;
		System.out.println("c="+c);
	}
}
