package com.cl.javabasis.day17regex;
/*
 * 正则表达式的构造摘要

预定义字符类
	. 任何字符（与行结束符可能匹配也可能不匹配） 
	\d 数字：[0-9] 
	\D 非数字： [^0-9] 
	\s 空白字符：[ \t\n\x0B\f\r] 
	\S 非空白字符：[^\s] 
	\w 单词字符：[a-zA-Z_0-9] 
	\W 非单词字符：[^\w] 
注意：任何预定义字符没有加上数量之前都只能匹配一个字符而已


Possessive 数量词
	X?+ X，一次或一次也没有 
	X*+ X，零次或多次 
	X++ X，一次或多次 
	X{n}+ X，恰好 n 次 
	X{n,}+ X，至少 n 次 
	X{n,m}+ X，至少 n 次，但是不超过 m 次 
	
	
字符类(范围词)
	[abc] a、b 或 c（简单类） 
	[^abc] 任何字符，除了 a、b 或 c（否定） 
	[a-zA-Z] a 到 z 或 A 到 Z，两头的字母包括在内（范围） 
	[a-d[m-p]] a 到 d 或 m 到 p：[a-dm-p]（并集） 
	[a-z&&[def]] d、e 或 f（交集） 
	[a-z&&[^bc]] a 到 z，除了 b 和 c：[ad-z]（减去） 
	[a-z&&[^m-p]] a 到 z，而非 m 到 p：[a-lq-z]（减去） 
注意，范围词里面不管内容有多长，没有数量词的配合都只能匹配一个字符而已

 * */
public class MyDemo2 {
	public static void main(String[] args) {
//		System.out.println("%".matches("."));			//任意字符
//		System.out.println("3".matches("\\d"));			//数组字符
//		System.out.println("~".matches("\\D"));			//非数组字符
//		System.out.println("\r".matches("\\s"));		//空白字符
//		System.out.println("a".matches("\\S"));			//非空白字符
//		System.out.println("a".matches("\\w"));			//单词字符
//		System.out.println("@".matches("\\W"));			//非单词字符
		
//		System.out.println("5".matches("\\d?"));				//?标识一次或一次都没有
//		System.out.println("324324".matches("\\d*"));			//*零次或多次
//		System.out.println("034".matches("\\d+"));				//至少出现一次
//		System.out.println("1034".matches("\\d{4}"));			//恰好出现n次
//		System.out.println("1034434".matches("\\d{4,}"));		//至少 n 次 
//		System.out.println("1054".matches("\\d{3,4}"));			//至少 n 次，但是不超过 m 次
		
//		System.out.println("aacb".matches("[abc]{4}"));			//a、b 或 c（简单类） 
//		System.out.println("@".matches("[^abc]"));
//		System.out.println("g@MyTest$".matches("[a-zA-Z$#@]+"));
		
	}
}
