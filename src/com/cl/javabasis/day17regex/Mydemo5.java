package com.cl.javabasis.day17regex;
/*
单词边界匹配器
	\b	单词边界匹配器只是代码了单词的开始或结束部分，不匹配任何的字符
 */
public class Mydemo5 {
	public static void main(String[] args) {
		System.out.println("Mydemo5 test".matches("Mydemo5\\b test"));
	}
}
