package com.cl.javabasis.day11;

import java.lang.reflect.Method;
import java.util.Arrays;

import javax.swing.plaf.TreeUI;

public class Test1 {
	public static void main(String[] args) {
//		method1();
//		System.out.println(method2(new int[]{13,45,12,13,23,65}));
//		method3();
//		int[] arr = new int[] { 13, 45, 12, 13, 23, 65, 3, 99, 43 };
//		System.out.println(method4(arr, 42));
		int[][] arr2=new int[][]{{1},{2,3},{4,5,6}};
		System.out.println(method5(arr2));
	}
	
	/**
	 * 定义一个程序。计算1-100奇数的总和,要求使用上continue关键字
	 * @author L
	 * @date 2016年3月19日
	 */
	static void method1(){
		int sum=0;
		for(int i=1;i<=10;i++){
			if(i%2==0){
				continue;
			}else {
				sum+=i;
			}
		}
		System.out.println(sum);
	}
	
	/**
	 * 定义一个函数接收一个数组对象,找出数组中的最大、最小值相加，把总和返回给调用者
	 * @author L
	 * @date 2016年3月19日
	 * @param arr
	 * @return
	 */
	static int method2(int[] arr){
		Arrays.sort(arr);
		return arr[0]+arr[arr.length-1];
	}
	
	/**
	 * 自定义一个数组，使用冒泡排序思想对数组的元素进行排序
	 * @author L
	 * @date 2016年3月19日
	 */
	static void method3() {
		int[] arr = new int[] { 13, 45, 12, 13, 23, 65, 3, 99, 43 };
		for (int j = 0; j < arr.length - 1; j++) {
			for (int i = 0; i < arr.length -1 - j; i++) {
				if (arr[i] > arr[i + 1]) {
					arr[i] = arr[i] ^ arr[i + 1];
					arr[i + 1] = arr[i] ^ arr[i + 1];
					arr[i] = arr[i] ^ arr[i + 1];
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * 定义一个函数，接收一个数组与一个要查找的元素，如果该元素存在数组中，
	 * 那么返回该元素在数组中的索引值，如果不存在返回-1
	 * @author L
	 * @date 2016年3月19日
	 * @param arr
	 * @param a
	 * @return
	 */
	static int method4(int[] arr,int a){
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int min=0;
		int max=arr.length-1;
		int mid=(min+max)/2;
		while(true){
			if(a>arr[mid]){
				min=mid+1;
				mid=(min+max)/2;
			}else if(a<arr[mid]){
				max=mid-1;
				mid=(min+max)/2;
			}else {
				return mid;
			}
			if(max<min){
				return -1;
			}
		}
	}
	
	/**
	 * 定义一个函数接收一个int类型的二维数组，计算该二维数组的所有元素之和，并且把总和返回给调用者
	 * @author L
	 * @date 2016年3月19日
	 * @param arr
	 * @return
	 */
	static int method5(int[][] arr){
		int sum=0;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				sum+=arr[i][j];
			}
		}
		return sum;
	}
	
	
}
