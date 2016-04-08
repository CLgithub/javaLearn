package com.cl.javabasis.day17regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 网络爬虫（网络蜘蛛）
 
 */
public class MyDemo6 {
	public static void main(String[] args) {
		String content="dffdsa1515@qq.cn 请联系我：123454515@163.com 请联系我：45816464@qq.com请联系我：14515616@qq.net 请联系我：14515316@qq.com.cn";
		String reg="[a-zA-Z1-9]\\w+@[a-zA-Z0-9]{2,}(\\.(com|cn|net)){1,2}";
		Pattern p=Pattern.compile(reg);
		Matcher m=p.matcher(content);
		while(m.find()){
			System.out.println(m.group());
		}
	}
}
