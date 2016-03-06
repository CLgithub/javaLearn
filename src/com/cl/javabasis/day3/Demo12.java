package com.cl.javabasis.day3;

/**
 *	三元运算符
 *	格式：布尔表达式?值1:值2 
 *		三元运算符要注意的细节：
 *			使用三元运算符的时候，一定要使用该表达式返回的结果，或者是定义一个变量接收该表达式返回的结果。
 */
public class Demo12 {
	public static void main(String[] args) {
//		int age=16;
//		System.out.println(age>=18?"成年人":"未成年人");
		
		int a = 1;
		int b = 2;
		int c = 3;

		int result = a*b+c/2+2*(a+b)/c;
		System.out.println("result="+result);
	}
}
