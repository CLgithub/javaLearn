package com.cl.javabasis.day3;

/**
 *	移动位运算符
 *		<<左移:左移，低位补0
 *			规律：一个操作数左移n位，等于该操作数乘以2的n次方
 *		>>右移：右移，如果最高位是0，则补0，最高位是1，则补1
 *			规律：一个操作数右移n位，等于该操作数除以2的n次方
 *		>>>无符右移 ：左移，最高位补0
 *
 *	笔试题目：使用最高效率算出2乘以8的结果
 *				2<<3=2*2(3)=2*8
 */
public class Demo11 {
	public static void main(String[] args) {
		//<<
		System.out.println(2<<9);
		//>>
		System.out.println(10>>2);
		System.out.println(-3>>1);
		System.out.println(Integer.toBinaryString(-3));
		//>>>
		System.out.println(3>>>1);
		System.out.println(-3>>>1);//2的31次方-2（01111111111111111111111111111110）
	}
}
