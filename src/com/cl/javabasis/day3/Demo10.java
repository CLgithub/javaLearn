package com.cl.javabasis.day3;

/**
 * 位运算符可能出现的笔试题目
 * 		1.交换两个变量的值,不准出现第三方变量
 * 		2.取出一个二进制数据的指定位数
 * 
 */
public class Demo10 {
	public static void main(String[] args) {
		int a=2;
		int b=5;
		//方法一：第三方变量
//		int c=a;
//		a=b;
//		b=c;
//		System.out.println("a="+a+",b="+b);
		
		//方法二：相加法， 缺点： 两个int类型的数据相加，有可能会出现超出int的表示范围。
//		a=a+b;
//		b=a+b;
//		a=b-a;
//		b=b-2*a;
		/******************************************************/
//		a=a+b;
//		b=a-b;
//		a=a-b;
//		System.out.println("a="+a+",b="+b);
		
		//方法三：异或，可以使用异或。 缺点： 逻辑不清晰。
		a = a^b;  // a = 3^5
		b = a^b;  // b = (3^5)^5 = 3
		a = a^b; //  a = (3^5)^3 = 5 
		System.out.println("a="+a+",b="+b);
		
	}
}
