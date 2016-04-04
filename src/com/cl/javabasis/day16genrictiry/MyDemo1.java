package com.cl.javabasis.day16genrictiry;

import java.util.ArrayList;

/**
 * 泛型是jdk1.5使用的新特性
 * 
 * 泛型的好吃：
 * 		1.将运行时的异常提前至了编译时
 * 		2.避免了无谓的强制类型转换
 * 
 * 泛型在集合中的常见应用：
 * 	ArrayList<String> arrayList=new ArrayList<String>();	true	推荐
 * 	ArrayList<Object> arrayList=new ArrayList<String>();	false
 * 	ArrayList<String> arrayList=new ArrayList<Ojbect>();	false
 * 	//以下两种主要是历史原因，兼容新老系统
 * 	ArrayList<String> arrayList=new ArrayList();			true
 * 	ArrayList arrayList=new ArrayList<String>();			true
 * 
 * 	注意：泛型没有多态的概念，左右两边的数据类型必须要一致，或者只写一边的泛型类型
 * 	推荐使用：两边都写ArrayList<String> arrayList=new ArrayList<String>();
 * 
 * 
 * 需求：把一个集合中的元素全部转成大写
 */
public class MyDemo1 {
	public static void main(String[] args) {
//		ArrayList<String> arrayList=new ArrayList<String>();//<String>标识该容器只能存储字符串类型的的数据
		ArrayList<String> arrayList=new ArrayList<String>();	//true	推荐这样写
//		ArrayList<Object> arrayList=new ArrayList<String>();	//false
//		ArrayList<String> arrayList=new ArrayList<Ojbect>();	//false
//		ArrayList<String> arrayList=new ArrayList();			//true
//		ArrayList arrayList=new ArrayList<String>();			//true
		arrayList.add("aa");
		arrayList.add("bb");
		arrayList.add("cc");
//		arrayList.add(123);
		
		for (int i = 0; i < arrayList.size(); i++) {
			String string =/*(String)*/ arrayList.get(i);
			System.out.println(string.toUpperCase());
		}
	}
}
