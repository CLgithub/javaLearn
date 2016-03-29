package com.cl.javabasis.day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * 	迭代
		toArray() 
 */
public class MyDemo3 {
	public static void main(String[] args) {
//		Collection c=new ArrayList();
//		c.add(new Person(1, "小明"));
//		c.add(new Person(2, "小白"));
//		c.add(new Person(3, "小黑"));
//		c.add(new Person(4, "小红"));
//		
//		//把集合中的全部元素放到一个object的数组中返回
//		Object[] arr=c.toArray();
//		System.out.println(c);
//		System.out.println("数组元素："+Arrays.toString(arr));
		
		Collection c=new ArrayList();
		c.add(new Person(1, "小明"));
		c.add(new Person(2, "小白"));
		c.add(new Person(3, "小黑"));
		c.add(new Person(4, "小红"));
		Object[] arr=c.toArray();
		//需求：把编号是3的人信息输出
		for (int i = 0; i < arr.length; i++) {
			Person p=(Person) arr[i];//从object数组中取出的元素，只能用object类型接收，如果需要其他类，需要强转
			if(p.id==3){
				System.out.println(p.name);
			}
		}
	}
}
