package com.cl.javabasis.day12;

import javax.security.auth.x500.X500Principal;

/**
 * 由于String是不可变的，所以导致String对象泛滥，在频繁改变字符串对象的应用中，
 * 需要使用可变的字符串缓冲区类。
 * StringBuffer其实就是个字符数组
 * 特点：
	1.默认缓冲区的容量是16。(看源码)
	2.StringBuffer  ： 线程安全的所有的缓冲区操作方法都是同步的。效率很低。
	
	笔试题目：使用Stringbuffer无 参的构造函数创建 一个对象时，默认的初始容量是多少？
	 如果长度不够使用了，自动增长多少倍？
	 	stringBuffer其实底层是依赖了一个字符数组来存储数据的，该字符数组默认的容量是16，
	 	如果字符数组的长度不够用是，自增长一倍+2，（capacity()）
	 	
	 容器具备的行为：
	 	增加
			append(boolean b)    可以添加任意类型 的数据到容器中
			insert(int offset, boolean b)  指定插入的索引值，插入对应 的内容。 

		删除
			delete(int start, int end)  根据指定的开始与结束的索引值删除对应的内容。
			deleteCharAt(int index)   根据指定 的索引值删除一个字符。
		
		修改
		
			replace(int start, int end, String str) 根据指定 的开始与结束索引值替代成指定的内容。
			reverse()   翻转字符串缓冲类的内容。  abc--->cba
			
	        setCharAt(int index, char ch)  把指定索引值的字符替换指定的字符。 
	        substring(int start, int end)  根据指定的索引值截取子串。
			ensureCapacity(int minimumCapacity)  指定StringBuffer内部的字符数组长度的。
			
		查看
			indexOf(String str, int fromIndex) 查找指定的字符串第一次出现的索引值,并且指定开始查找的位置。
			lastIndexOf(String str) 
			
			capacity() 查看当前字符数组的长度。 
			length() 
			
			charAt(int index) 
			toString()   把字符串缓冲类的内容转成字符串返回。
			
	StringBuffer与StringBuilder的相同与不同
		相同点：
			1、两个类都是字符串的缓存类
			2、两个类的方法都是一致的
		不同点：
			1、StringBuffer是线程安全的，StringBuilder是线程不安全的
			(线程安全：在一个时间内，只能有一个线程执行这段代码，操作效率低，（有点像事物），
			线程不安全：在一个时间内，可以有多个线程来执行这段代码，操作效率高
			)
			2、stringBuffer是jdk1.0出现，stringBuiler是jdk1.5出现的
			
 * @author L
 * @date 2016年3月20日
 */
public class MyDemo4 {
	public static void main(String[] args) {
//		method1();
//		testAppend();
//		testInsert();
//		testDelete();
//		testDeleteCharAt();
//		testReplace();
//		testReverse();
//		testSetCharAt();
//		testSubstring();
//		testEnsureCapacity();
//		testIndexof();
//		testCapacity();
//		testcharAt();
		testToStirng();
	}
	
	static void method1(){
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append("java");
		sBuffer.append("java");
		sBuffer.append("java");
		sBuffer.append("java");
		sBuffer.append("java");
		System.out.println(sBuffer.capacity());
	}
	
	/**
	 * 可以添加任意类型 的数据到容器中
	 * @author L
	 * @date 2016年3月20日
	 */
	static void testAppend(){
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append("java");
		sBuffer.append(true);
		sBuffer.append(3.14f);
		sBuffer.append("java");
		System.out.println(sBuffer);
	}
	
	/**
	 * 定插入的索引值，插入对应 的内容。 
	 * @author L
	 * @date 2016年3月20日
	 */
	static void testInsert(){
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append("java");
		sBuffer.insert(1, "x");
		System.out.println(sBuffer);
	}
	
	/**
	 * 根据指定的开始与结束的索引值删除对应的内容。
	 * @author L
	 * @date 2016年3月20日
	 */
	static void testDelete(){
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append("abcdefg");
		sBuffer.delete(2, 4);
		System.out.println(sBuffer);
	}
	
	/**
	 * 根据指定 的索引值删除一个字符。
	 * @author L
	 * @date 2016年3月20日
	 */
	static void testDeleteCharAt(){
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append("abcdefg");
		sBuffer.deleteCharAt(0);
		System.out.println(sBuffer);
	}
	
	/**
	 * 根据指定 的开始与结束索引值替代成指定的内容。
	 * @author L
	 * @date 2016年3月20日
	 */
	static void testReplace(){
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append("abcdefg");
		sBuffer.replace(1, 3, "xxxx");
		System.out.println(sBuffer);
	}
	
	/**
	 * 
	 * @author L
	 * @date 2016年3月20日
	 */
	static void testReverse(){
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append("abcdefg");
		sBuffer.reverse();
		System.out.println(sBuffer);
	}
	
	/**
	 * 把指定索引值的字符替换指定的字符
	 * @author L
	 * @date 2016年3月20日
	 */
	static void testSetCharAt(){
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append("abcdefg");
		sBuffer.setCharAt(0, 'x');
		System.out.println(sBuffer);
	}
	
	/**
	 * 根据指定的索引值截取子串。
	 * @author L
	 * @date 2016年3月20日
	 */
	static void testSubstring(){
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append("abcdefg");
		System.out.println(sBuffer.substring(2,4));
	}
	/**
	 * 指定StringBuffer内部的字符数组长度的。
	 * @author L
	 * @date 2016年3月20日
	 */
	static void testEnsureCapacity(){
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.ensureCapacity(10);
		sBuffer.append("abcdefg");
		System.out.println(sBuffer.capacity());
	}
	
	/**
	 * 查找指定的字符串第一次出现的索引值,并且指定开始查找的位置。
	 * @author L
	 * @date 2016年3月20日
	 */
	static void testIndexof(){
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append("abcdefg");
		System.out.println(sBuffer.indexOf("c",1));
	}
	
	/**
	 * capacity查看当前字符数组的长度。 
	 * length
	 * @author L
	 * @date 2016年3月20日
	 */
	static void testCapacity(){
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append("abcdefgabcdefgaa2");
		System.out.println(sBuffer.capacity());
		System.out.println(sBuffer.length());
	}
	
	/**
	 * 
	 * @author L
	 * @date 2016年3月20日
	 */
	static void testcharAt(){
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append("abcdefgabcdefgaa2");
		System.out.println(sBuffer.charAt(2));
	}
	
	/**
	 * 把字符串缓冲类的内容转成字符串返回。
	 * @author L
	 * @date 2016年3月20日
	 */
	static void testToStirng(){
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append("abcdefgabcdefgaa2");
		System.out.println(sBuffer.toString());
	}
	
	
}
