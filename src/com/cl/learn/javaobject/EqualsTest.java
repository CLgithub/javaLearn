package com.cl.learn.javaobject;

public class EqualsTest {
	
	public static void main(String[] args) {
//		System.out.println(2<<10);
		String str1=new String("abc");
		String str2=new String("abc");
		String str3=str1;
		if(str1.equals(str2)){
			System.out.println("1");
		}
		if(str1==str2){
			System.out.println("2");
		}
		if(str1.equals(str3)){
			System.out.println("3");
		}
		if(str1==str3){
			System.out.println("4");
		}
		if(str3.equals(str2)){
			System.out.println("5");
		}
		if(str3==str2){
			System.out.println("6");
		}
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());
		
//		Object i1=new StringBuffer(23);
//		Object i2=new StringBuffer(23);
//		if(i1.equals(i2)){
//			System.out.println("EqualsTest.main()");
//		}
//		System.out.println(i1.hashCode());
//		System.out.println(i2.hashCode());
	}
}
