package com.cl.javabasis.day18jdk15;
/*
 switch判断条件适用的数据类型：byte\short\int\char\String\枚举类型
 
 主要：
 	在switch语句中，case语句后面跟的枚举类，只需要单写枚举值即可，不需要声明该枚举值是属于哪个枚举类的
 */

public class MyDemo8 {
	public static void main(String[] args) {
		Season season=Season.summer;
		switch (season) {
		case spring:
			System.out.println("春天");
			break;
		case summer:
			System.out.println("夏天");
			break;
		case autumn:
			System.out.println("秋天");
			break;
		case winter:
			System.out.println("冬天");
			break;
		default:
			break;
		}
	}
}
//季节枚举类
enum Season{
	spring,summer,autumn,winter;
}
enum Season1{
	spring,summer,autumn,winter;
}