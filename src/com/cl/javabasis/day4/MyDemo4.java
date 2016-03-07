package com.cl.javabasis.day4;

public class MyDemo4 {

	public static void main(String[] args) {
		int[] array1={1,4,7,9,23,45,1,32,78,90,23,10,21,12};
		method2(array1);
	}
	/**
	 * 找到一个int数组中最大的元素
	 * @author L
	 * @date 2016年3月7日
	 * @param str2
	 */
	private static void method1(int[] array) {
		int max=0;
		for(int i=0; i<array.length;i++){
			if(array[i]>max){
				max=array[i];
			}
		}
		System.out.println(max);
	}
	
	/**
	 * 数组排序，直接排序
	 * @author L
	 * @date 2016年3月7日
	 */
	private static void method2(int[] array){
		for(int i=0;i<array.length;i++){
			for(int j=i+1;j<array.length;j++){
				if(array[j]>array[i]){
					array[i]=array[i]^array[j];
					array[j]=array[i]^array[j];
					array[i]=array[i]^array[j];
				}
			}
		}
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}
	
	/**
	 * 数组排序，冒泡排序
	 * 比较方式：相邻两个元素进行比较。如果满足条件就进行位置置换。
	 * 原理：内循环结束一次，最值出现在尾角标位置。
	 * @author L
	 * @date 2016年3月7日
	 * @param array
	 */
	private static void method3(int[] array){
		for(int i=0;i<array.length;i++){
			for(int j=i+1;j<array.length;j++){
				
			}
		}
	}
	
}
