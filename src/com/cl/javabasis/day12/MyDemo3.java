package com.cl.javabasis.day12;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MyDemo3 {
	public static void main(String[] args) {
		String path="D:\\20120512\\day12\\Demo1.java";
//		getFileName(path);
		method1();
//		getCount(path, "2");
	}
	
	/**
	 * 获取上传文件名  "D:\\20120512\\day12\\Demo1.java"
	 * @author L
	 * @date 2016年3月20日
	 * @param path
	 */
	static void getFileName(String path){
		System.out.println(path.substring(path.lastIndexOf("\\")+1));
	}
	
	/**
	 * 3.将字符串对象中存储的字符反序。
	 * @author L
	 * @date 2016年3月20日
	 */
	static void method1(){
		//方法一
		String str="abc; d";
		char[] cs=str.toCharArray();
		for(int i=0;i<cs.length/2;i++){
			cs[i]=(char) (cs[i]^cs[cs.length-1-i]);
			cs[cs.length-1-i]=(char) (cs[i]^cs[cs.length-1-i]);
			cs[i]=(char) (cs[i]^cs[cs.length-1-i]);
		}
		System.out.println(new String(cs));
		//方法二
		String str2="abc; d";
		StringBuffer sBuffer=new StringBuffer(str2);
		sBuffer.reverse();
		System.out.println(sBuffer);
	}
	
	/**
	 * 求一个子串在整串中出现的次数
	 * @author L
	 * @date 2016年3月20日
	 */
	static void getCount(String str,String tag){
		int count=0;
		int index=0;
		while(index!=-1){
			index=str.indexOf(tag);
			str=str.substring(index+1);
			count++;
//			System.out.println(str);
		}
		System.out.println(count-1);
	}
}
