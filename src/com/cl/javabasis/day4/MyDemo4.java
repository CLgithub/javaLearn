package com.cl.javabasis.day4;

public class MyDemo4 {

	public static void main(String[] args) {
		int[] array1={1,4,7,9,23,45,1,32,78,90,23,10,21};
		int[] array2={1,4};
		method4(array1,1);
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
	private static int method4(int[] array,int key){
		int conut=0;
		int min,mid,max;
		min=0;
		max=array.length;
		mid=(min+max)/2;
		while(key==array[mid]){
			conut++;
			if(key>array[mid]){
				min = mid + 1;
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
	
}
