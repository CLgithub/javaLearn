package com.cl.javabasis.day17regex;

import java.util.Arrays;

/*
正则表达式注意是用于操作字符串的规则，正则表达式对字符串的操作主要有以下几种应用：
	匹配：matches()
	
	切割：
	
	替换：
	
	查找：
 * */
public class MyDemo3 {
	public static void main(String[] args) {
//		mathesPhoneN("13845451546");
//		mathesTel("0383-52345678");
//		tesSplit1();
//		testSplit2();
		mathesEmail1();
	}
	
	//匹配手机号,第一位只能是1，第一二位3,5,7,8	长度11，全是数字
	public static void mathesPhoneN(String phoneN){
		String reg="1[3578]\\d{9}";
		System.out.println(phoneN.matches(reg));
	}
	//匹配固定电话：区号-主机号	区号：首位是0，长度3~4，主机号：首位不能是0，长度是7~8
	public static void mathesTel(String tel){
		String reg="0\\d{2,3}-[1-9]\\d{6,7}";
		System.out.println(tel.matches(reg));
	}
	
	//按空格切割
	public static void tesSplit1(){
		String str="明   天     放                                   假";
		String[] strings=str.split(" {1,}");//至少有一个空格
		System.out.println(Arrays.toString(strings));
	}
	
	//根据重叠词进行切割
	public static void testSplit2(){
		String str="大家家明天天天玩得得得得开心";//大 明 玩 开心
		String[] strs=str.split("(.)\\1+");//如果正则的内容需要被复用，那么需要对正则的内容进行分组，分组的目的就是为了提高正则的复用性
		String[] strs2=str.split("(.)\\1{1,}");// \\1表引用第一个分组，+和{1,}都表示出现一个或一个以上次数
		System.out.println(Arrays.toString(strs2));
	}
	
	//匹配一个邮箱，xxx@xxx.xx
	public static void mathesEmail1(){
		String myEmail="sdffd@gmail.com";
		String reg="[a-zA-Z0-9]+@[a-zA-Z0-9\\.]+";
		System.out.println(myEmail.matches(reg));
	}
}
