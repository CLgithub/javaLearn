package com.cl.javabasis.day4;

public class MyDemo3 {
	
	/**
	 * 转意字符,
	 * 注意：换行符就是另起一行，回车符就是回到一行的开头，
	 * 所以我们平时编写文件的回车符应该确切来说叫做回车换行符
	 * @author L
	 * @date 2016年3月7日
	 * @param args
	 */
	public static void main(String[] args) {
		String string="abc";
		System.out.println(string+'\b');	//退格键，相当于Back Space
		System.out.println(string+'\t');	//table键
		System.out.println(string+'\n');	//换行 均为windows下，晚上回去试试osx
		System.out.println(string+'\r');	//回车符
		System.out.println(string+'\\');	//输出\
		System.out.println(string+'\'');	//输出'
		System.out.println(string+'\"');	//输出"
	}
}
