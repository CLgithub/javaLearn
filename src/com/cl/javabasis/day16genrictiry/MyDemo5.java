
package com.cl.javabasis.day16genrictiry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * 泛型的上下限：
 * 
 * 需求：定义一个函数可以接受任意类型的集合对象，要求集合对象只能吃醋integer或integer的父类类型数据
 * 
 * 泛型中的通配符：? super Integer
 * 
 * 需求2：定义一个函数可以接受任意类型的集合对象，要求集合对象只能吃醋Number或Number的子类类型数据
 * 
 * 	? extends Number
 * 
 */
public class MyDemo5 {
	public static void main(String[] args) {
		ArrayList<Integer> list=new ArrayList<Integer>();
		ArrayList<Number> list2=new ArrayList<Number>();
		ArrayList<String> list3=new ArrayList<String>();
		
		HashSet<Integer> set =new HashSet<Integer>();
		HashSet<String> set2 =new HashSet<String>();
		
//		method1(list);
//		method1(list2);
//		method1(list3);	//false
//		method1(set);
//		method1(set2);	//false
//		
//		method2(list);
//		method2(list2);
//		method2(list3);	//false
//		method2(set);
//		method2(set2);	//false
	}
	
	//Collection里面的数据类型是泛型，该泛型是Integer或Integer的父类类型，下限
	public static void method1(Collection<? super Integer> c){
		
	}
	
	//Collection里面的数据类型是泛型，该泛型继承Number，是Number或Number的子类类型，上限
	public static void method2(Collection<? extends Number> c){
		
	}
}
