package com.cl.javabasis.day16genrictiry;

import java.util.Arrays;

/**
 * 需求：编写一个数组的工具类
 * 
 * 泛型类：
 * 	泛型类的定义格式：
 * 		class 类名<声明自定义泛型>{
 * 		}
 * 	
 * 	泛型类要注意的事项：
 * 		1.在类上自定义泛型的具体数据类型是在使用该类创建对象的时候确定的
 * 		2.如果一个类在类上已经声明了自定义泛型，如果使用该类型创建对象的时候没有指定具体泛型类型，默认为object
 * 		3.在类上自定义的泛型不能作用于静态的方法，如果静态的方法需要使用自定义泛型，那么需要自己声明
 * 
 */
public class MyDemo3 {
	public static void main(String[] args) {
		Integer[] arr={10,12,14,19};
		
		MyArraysTools<Integer> myArraysTools=new MyArraysTools<Integer>();
		myArraysTools.reverse(arr);
		System.out.println(myArraysTools.toStringArr(arr));
//		System.out.println(Arrays.toString(arr));
		
		String[] arr2={"aa","bb","cc","xx"};
		MyArraysTools<String> myArraysTools2=new MyArraysTools<String>();
		myArraysTools2.reverse(arr2);
		System.out.println(myArraysTools2.toStringArr(arr2));
		
		MyArraysTools myArraysTools3=new MyArraysTools();
		myArraysTools3.reverse(arr2);
		
		MyArraysTools.myPrint(arr2);
	}
	
//	static class Test1<T>{
//		public static void myPring(T[] t){
//			
//		}
//	}
}

class MyArraysTools<T>{
	
	//元素反转
	public /*<T>*/void reverse(T[] arr) {
		for (int startIndex = 0, endIndex = arr.length-1; startIndex < endIndex; startIndex++, endIndex--) {
			T tmp=arr[startIndex];
			arr[startIndex]=arr[endIndex];
			arr[endIndex]=tmp;
		}
	}

	//打印数组
	public /*<T>*/String toStringArr(T[] arr) {
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if(i==0){
				sb.append("["+arr[i]+",");
			}else if(i==arr.length-1){
				sb.append(arr[i]+"]");
			}else {
				sb.append(arr[i]+",");
			}
		}
		return sb.toString();
	}
	
	public static <T>void myPrint(T[] arr){
		System.out.println(Arrays.toString(arr));
	}
}
