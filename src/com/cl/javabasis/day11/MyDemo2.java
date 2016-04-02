package com.cl.javabasis.day11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 目前有数组 int[] arr={11,2,4,2,10,11};
 * 定义一个函数清除该数组的重复元素，
 * 返回的数组存储了那些非重复的元素而且不准浪费长度
 * 2,4,10,11
 * @author L
 * @date 2016年3月19日
 */
public class MyDemo2 {
	public static void main(String[] args) {
		int[] arr={11,2,4,2,10,11,13};
		int[] arr2=method(arr);
		System.out.println(Arrays.toString(arr2));
	}

	private static int[] method(int[] arr) {
		Arrays.sort(arr);
		int count=0;
		for(int i=0;i<arr.length-1;i++){
			if(arr[i]==arr[i+1]){
				count++;
			}
		}
//		System.out.println(Arrays.toString(arr));
		int index=0;
		int[] arr2=new int[arr.length-count];
		for(int i=0;i<arr.length;i++){
			boolean flag=false;
			for(int j=0;j<arr2.length;j++){
				if(arr2[j]==arr[i]){
					flag=true;
					break;
				}
			}
			if(!flag){
				arr2[index++]=arr[i];
			}
		}
		return arr2;
	}
	private static int[] method2(int[] arr) {
		Set<Integer> set=new HashSet<>();
		for(int i=0;i<arr.length;i++){
			set.add(arr[i]);
		}
		int[] arr2=new int[set.size()];
		Iterator iterator=set.iterator();
		for(int i=0;i<arr2.length;i++){
			arr2[i]=(int) iterator.next();
		}
		return arr2;
	}
}
