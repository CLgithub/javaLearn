package com.cl.javabasis.day7;

import java.util.Arrays;

/*
定义数组工具类
1:定义一个遍历数组的函数
2:定义一个求数组和的功能函数  1. 遍历  2. 两两相加
3:定义一个获取数组最大值的功能函数
4:定义一个获取数组最大值角标的功能函数
5:定义一个返回指定数在指定数组中包含的角标的功能函数
6:定义一个可以用于排序int数组的函数
	1:冒泡
	2:选择
	
定义自己的工具类
	
*/
public class DayJob {
	public static void main(String[] args) {
		int[] array1=new int[]{23,43,12};
//		print(array1);
//		sum(array1);
//		getMaxValue(array1);
//		getMaxVKye(array1);
		System.out.println(getKey(array1, 12));
//		Sort2(array1);
		
	}
	
	//遍历数组的函数
	private static void print(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
//		System.out.println(Arrays.toString(array));
	}
	//求数组和的功能函数  1. 遍历  2. 两两相加
	private static void sum(int[] array){
		int sum = 0;
		for(int i=0;i<array.length;i++){
			sum+=array[i];
		}
		System.out.println(sum);
	}
	//获取数组最大值
	private static void getMaxValue(int[] array){
		int max=0;
		for(int i=0;i<array.length;i++){
			if(max<array[i]){
				max=array[i];
			}
		}
		System.out.println(max);
	}
	//获取数组最大值角标
	private static void getMaxVKye(int[] array){
		int x=0;
		int max=0;
		for(int i=0;i<array.length;i++){
			if(max<array[i]){
				max=array[i];
				x=i;
			}
		}
		System.out.println(x);
	}
	//返回指定数在指定数组中包含的角标的功能函数,如果不存在，返回-1
	private static int getKey(int[] array,int value){
		/*int x=-1;
		for(int i=0;i<array.length;i++){
			if(value==array[i]){
				x=i;
			}
		}
		return x;*/
		//先排升序，再二分
		Sort2(array);
		int min=0;
		int max=array.length-1;
		int mid=(min+max)/2;
		while(value!=array[mid]){
			if(value>array[mid]){
				min=mid+1;//妙处
			}else if(value<array[mid]){
				max=mid-1;
			}
			if(min>max){//妙处
				return -1;
			}
			mid=(min+max)/2;
		}
		return mid;
	}
	//可以用于排序int数组的函数,选择排序,第一个逐个与其他比较，第二个逐个月其他比较	
	private static void Sort1(int[] array){
		for(int i=0;i<array.length-1;i++){//不用拿最后一个去比较
			for(int j=i+1;j<array.length;j++){//每次都要比较到最后一个
				if(array[i]>array[j]){
					array[i]=array[i]^array[j];
					array[j]=array[i]^array[j];
					array[i]=array[i]^array[j];
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}
	//可以用于排序int数组的函数,冒泡排序，相邻两个比较
	private static void Sort2(int[] array){
		for(int i=0;i<array.length-1;i++){//第一次要用倒数第二个与最后一个相比较
			for(int j=0;j<array.length-1-i;j++){//第一次要用倒数第二个与最后一个相比较
				if(array[j]>array[j+1]){
					array[j+1]=array[j+1]^array[j];
					array[j]=array[j+1]^array[j];
					array[j+1]=array[j+1]^array[j];
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}
}
