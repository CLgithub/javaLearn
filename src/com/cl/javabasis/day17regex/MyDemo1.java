package com.cl.javabasis.day17regex;
/*
正则表达式：正则表达式其实就是用于操作字符串的一个规则，正则表达式的规则使用了特殊的符合标识

需求：校验一个qq号
	1.不能以0开头。
	2.长度5~11位
	3.只能又数字组成
 */
public class MyDemo1 {
	public static void main(String[] args) {
		String qq="1114567";
		
		/*if(!qq.startsWith("0")){
			if(qq.length()>=5&&qq.length()<=11){
				try{
					Long.parseLong(qq);
					System.out.println("成功");
				}catch(Exception e){
					System.out.println("只能用数组组成");
				}
			}else {
				System.out.println("长度非法");
			}
		}else {
			System.out.println("非法，不能以0开头");
		}*/
		
		System.out.println(qq.matches("[1-9]\\d{4,10}")?"合法":"非法");
	}
}
