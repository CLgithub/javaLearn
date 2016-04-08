package com.cl.javabasis.day17regex;

import java.awt.PageAttributes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
正则表达式注意是用于操作字符串的规则，正则表达式对字符串的操作主要有以下几种应用：
	匹配：matches()
	
	切割：split()
	
	替换：replaceAll(String regex, String replacement)
	
	查找：
			
指定为字符串的正则表达式必须首先被编译为此类的实例。然后，可将得到的正则对象匹配任意的字符串用于创建 Matcher 对象，
依照正则表达式，该对象可以与任意字符序列匹配。执行匹配所涉及的所有状态都驻留在匹配器中，所以多个匹配器可以共享同一模式。 

因此，典型的调用顺序是 

 Pattern p = Pattern.compile("a*b");
 Matcher m = p.matcher("aaaaab");
 boolean b = m.matches();

需要使用的对象
		1.Pattern	正则对象
		2.Matcher	匹配器对象
匹配器要使用的方法：
	 boolean find()  通知匹配器去匹配字符串，查找符合规则的字符串，如果能查到则返回true，否则false
	 String group()  获取符合规则的子串
  注意：使用group方法的时候，一定要先调用find方法让匹配器去查找符合规则的字符串

 * */
public class MyDemo4 {
	public static void main(String[] args) {
		//需求：找出三个字母组成的单词
		String str="da jia de ja qi wan bi liao hai kai xin ma";
		Pattern p=Pattern.compile("\\b[a-zA-Z]{3}\\b");//首先把字符串对象编译成正则对象p
		Matcher m=p.matcher(str);//然后将正则对象p匹配字符串str创建Matcher一个对象m，将信息驻留在匹配器对象m中
		while(m.find()){				//通过匹配器去获取
			System.out.println(m.group());
//			System.out.println(str.replace(m.group(), "***"));
		}
	}
}
