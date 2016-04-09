package com.cl.javabasis.day18jdk15;


import java.util.ArrayList;
import java.util.Collections;
/**
 jdk1.5新特性之-----------静态导入
 	静态导入的作用：简化书写
 	静态导入可以作用一个类的所有静态成员
 	静态导入的格式：
 		import static 包名.类名.静态的成员
 		
 	静态导入要注意的事项：
 		1. 如果静态导入的成员与本类的成员存在同名的情况下，那么默认使用本类的静态成员，
 			如果需要指定使用静态导入的成员，那么需要在静态成员前面加上类名
 */
import static java.util.Collections.sort;
import static java.util.Collections.binarySearch;
import static java.util.Collections.max;
//import static java.util.Collections.*;
import static java.lang.System.out;//静态导入可以作用一个类的所有静态成员
public class MyDemo1 {
	public static void main(String[] args) {
		ArrayList<Integer> list=new ArrayList<>();
		list.add(13);
		list.add(9);
		list.add(10);
		list.add(19);
		//排序
		Collections.sort(list);
		out.println(list);
		//查找
		out.println(binarySearch(list, 13));
		out.println("最大值："+max(list));
	}
	//本类有同名就用本类
	public static void sort(/*ArrayList<Integer> list*/){
		System.out.println("本类的sort方法");
	}
}
