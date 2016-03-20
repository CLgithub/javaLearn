package com.cl.javabasis.day12;

import java.util.Arrays;

/**
 * String
 * @author L
 * @date 2016年3月20日
 */
public class MyDemo2 {
	public static void main(String[] args) {
		String str1="hello";
		String str2="hello";
		String str3=new String("hello");
		String str4=new String("hello");
		
		/*System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());*/
		
		//2.1比较
//		System.out.println(str1==str2);
//		System.out.println(str1.equals(str2));
//		
//		System.out.println(str1==str3);
//		System.out.println(str1.equals(str3));
//		
//		System.out.println(str3==str4);
//		System.out.println(str3.equals(str4));
		
//		//2.2获取
//		System.out.println("判断某位置的字符:"+str1.charAt(3));//判断某位置的字符
//		System.out.println("查找某字符第一次出现在字符串中的位置:"+str1.indexOf('a'));//查找某字符第一次出现在字符串中的位置
//		System.out.println("查找某字符最后出现在字符串中的位置:"+str1.lastIndexOf('l'));//查找某字符最后出现在字符串中的位置
//		
//		//2.3判断
//		System.out.println("否以指定字符结束:"+str1.endsWith("o"));//判断是否以指定字符结束
//		System.out.println("是否长度为0 如:"+str1.isEmpty());//是否长度为0 如：""
//		System.out.println("是否包含指定序列:"+str1.contains("he"));//是否包含指定序列 应用：搜索
//		System.out.println("比较堆内存中的内容:"+str1.equals(str2));//比较堆内存中的内容
//		System.out.println("忽略大小写比较堆内存中的内容:"+str1.equalsIgnoreCase("Hello"));//忽略大小写比较堆内存中的内容
//		
//		//2.4转换
//			//将字符数组转换为字符串
//		String str5=new String(new char[]{'t','e','s','t'});//String(char[] value)
//		System.out.println(str5);
//		char[] buff=new char[]{'t','e','s','t','2'};
//		String str6=new String(buff,0,buff.length);//String(char[] value, int offset, int count)
//		System.out.println(str6);
//		String str7=new String(buff);//String(char[] value)
//		System.out.println(str7);
//		System.out.println(str7.valueOf('a'));
//			//将字符串转换为字符数
//		char[] cs=str7.toCharArray();
//		System.out.println(Arrays.toString(cs));
		
		//其他方法
//		String str8=" test String";
//		System.out.println(str8.replace('s', 'b'));//替换
//		String[] strings=str8.split("i");//切割
//		System.out.println(Arrays.toString(strings));
//		System.out.println(str8.substring(1));//截取字符串
//		System.out.println(str8.toUpperCase());//转换为大写
//		System.out.println(str8.toLowerCase());//转换为小写
//		System.out.println(str8.trim());//去前后空格
		
		
		
	}
}
