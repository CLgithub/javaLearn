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
		System.out.println("1:"+string+'\b');	//退格键，相当于Back Space
		System.out.println("2:"+string+'\t');	//table键
		System.out.println("3:"+string+'\n');	//换行 均为windows下，晚上回去试试osx
		System.out.println("4:"+string+'\r');	//回车符
		System.out.println("5:"+string+'\\');	//输出\
		System.out.println("6:"+string+'\'');	//输出'
		System.out.println("7:"+string+'\"');	//输出"
	}
}
