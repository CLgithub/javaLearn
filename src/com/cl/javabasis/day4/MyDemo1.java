package com.cl.javabasis.day4;

public class MyDemo1 {
	public static void main(String[] args) {
//		method1();
//		method2();
		method3();
	}
	
	/**
	 * 利用switch
	 * @author L
	 * @date 2016年3月7日
	 */
	public static void method1(){
		int x=14;
		switch (x) {
		case 1:
		case 2:
		case 3:
			System.out.println("春");
			break;
		case 4:
		case 5:
		case 6:
			System.out.println("夏");
			break;
		case 7:
		case 8:
		case 9:
			System.out.println("秋");
			break;
		case 10:
		case 11:
		case 12:
			System.out.println("冬");
			break;
		default:
			break;
		}
	}
	/**
	 * 适用于均分
	 * @author L
	 * @date 2016年3月7日
	 */
	public static void method2(){
		int x=3;
		String[] jijies={"春","夏","秋","冬 "};
		if(x<=12){
			int i=0;
			i=x/4;
			System.out.println(jijies[i]);
		}
	}
	
	/**
	 * jdk7后可以是字符串，之前只能是4种整型：byte、short、int、char
	 * @author L
	 * @date 2016年3月7日
	 */
	public static void method3() {
		String string = "a";
		switch (string) {
		case "a":
			System.out.println("a");
			break;
		case "b":
			System.out.println("b");
		default:
			break;
		}
	}
}
