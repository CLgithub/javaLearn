package com.cl.javabasis.day17map;

import java.util.Arrays;
import java.util.List;

/*
Arrays:用于对数组操作的工具类
	1，二分查找,数组需要有序
		binarySearch(int[])
		binarySearch(double[])
	
	2，数组排序
		sort(int[])
		sort(char[])……
	2，将数组变成字符串。
	 	toString(int[])
	3，复制数组。
	 	copyOf(boolean[] original,int newLength);
	 	original 源数组
	 	newLength 新数组长度
	4，复制部分数组。
		copyOfRange(boolean[] original, int from, int to)
		original 源数组
		from 开始拷贝的索引值
		to 结束的索引值
	5，比较两个数组对应位置的元素是否一致。
		equals(int[],int[]);
	6，将数组变成集合。
		List asList(T[]);
		这样可以通过集合的操作来操作数组中元素，
		但是不可以使用增删方法，add，remove。因为数组长度是固定的，会出现
		UnsupportOperationExcetion。
		可以使用的方法：contains，indexOf。。。
		如果数组中存入的基本数据类型，那么asList会将数组实体作为集合中的元素。
		如果数组中的存入的引用数据类型，那么asList会将数组中的元素作为集合中
		的元素。
 */
public class MyDemo8 {
	public static void main(String[] args) {
		Integer[] arr={2,4,8,5,1,15,7};
		Integer[] arr2=/*{2,4,8,1,5,15,7};*/Arrays.copyOf(arr,10);
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 1, 9)));
//		
		System.out.println("判断两个数组的元素是否完全一致："+Arrays.equals(arr, arr2));//对应位置
//		
		List<Integer> list=Arrays.asList(arr2);//数组变数组
		list.toArray();//list便数组
		System.out.println(list);
	}
}
