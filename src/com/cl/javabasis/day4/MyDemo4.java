package com.cl.javabasis.day4;

import java.util.ArrayList;
import java.util.Arrays;

public class MyDemo4 {

	public static void main(String[] args) {
		//数组初始化的三种方式
		int[] array1={1,4,7,9,25,45,11,32,78,90,23,10,21};
		int[] array3=new int[100];
		int[] array2=new int[]{23,34,12};
		for(int i=1;i<array3.length;i++){
			array3[i]=i;
		}
//		method4(array3,98);
//		method5(array3,98);
//		method6(array1);
		method7();
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
		int conut=0;
		for(int i=0;i<array.length-1;i++){
			for(int j=i+1;j<array.length;j++){
				conut++;
				if(array[j]>array[i]){
					array[i]=array[i]^array[j];
					array[j]=array[i]^array[j];
					array[i]=array[i]^array[j];
				}
			}
		}
		System.out.println("循环"+conut);
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
		int conut=0;
		for(int i=0;i<array.length-1;i++){
			for(int j=0;j<array.length-1-i;j++){
				conut++;
				if(array[j]>array[j+1]){
					array[j+1]=array[j+1]^array[j];
					array[j]=array[j+1]^array[j];
					array[j+1]=array[j+1]^array[j];
				}
			}
		}
		System.out.println("循环"+conut);
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}
	
	/**
	 * 查找某目标值在数组中的索引
	 * 折半查找(二分法)
	 * 为了提高查找效率，可使用折半查找的方式，注意：这种查找只对有序的数组有效.
	 * 这种方式也成为二分查找法。
	 * @author L
	 * @date 2016年3月8日
	 * @param array 
	 * @param key 要查找的目标值
	 * @return 
	 */
	 static int method4(int[] array,int key){
//		method3(array);
		int conut=0;
		int min,mid,max;
		min=0;
		max=array.length-1;
		mid=(min+max)/2;
		while(key!=array[mid]){
			conut++;
			if(key>array[mid]){
				min = mid + 1;//妙处
			}else if(key<array[mid]){
				max = mid - 1;
			}
			if(min>max) {
				return -1;
			}
			mid = (max+min)/2;
		}
		System.out.println("目标值为："+key+",数组脚标为"+mid);
		System.out.println("循环"+conut);
		return mid;
	}
	
	/**
	 * 对method4进行改进,但其实4已经够好了
	 */
	private static int method5(int[] array,int key){
//		method3(array);
		int conut=0;
		int min,mid,max;
		min=0;
		max=array.length-1;
		mid=(min+max)/2;
		while(key!=array[mid]){
			conut++;
			if(key>array[mid]){
				min = mid;
			}else if(key<array[mid]){
				max = mid;
			}
//			if(min+1==max) {
//				return -1;
//			}
			mid = (max+min)/2;
		}
		System.out.println("目标值为："+key+",数组脚标为"+mid);
		System.out.println("循环"+conut);
		return mid;
	}
	
	/*
	反转其实就是头角标和尾角标的元素进行位置的置换，
	然后在让头角标自增。尾角标自减。
	当头角标<尾角标时，可以进行置换的动作。
	*/
	private static void method6(int[] array){
		int min=0;
		int max=array.length-1;
		while(min<max){
			array[min]=array[min]^array[max];
			array[max]=array[min]^array[max];
			array[min]=array[min]^array[max];
			min++;
			max--;
		}
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}
	
	/**
	 * 用Arrays里的静态方法处理数组
	 * @author L
	 * @date 2016年3月8日
	 */
	private static void method7(){
		int[] a=new int[]{23,54,12,76,43};
		//将数组的元素以字符串的形式返回
		System.out.println(Arrays.toString(a));
		//将数组升序排序
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		//binarySearch()在指定数组中查找指定元素，返回元素的索引，
		//如果没有找到返回（-插入点-1） 注意：使用查找的功能的时候，
		//数组一定要先排序。
		int i=Arrays.binarySearch(a, 54);
		System.out.println(i);
	}
}
