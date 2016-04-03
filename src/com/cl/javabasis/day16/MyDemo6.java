package com.cl.javabasis.day16;

import java.util.Iterator;
import java.util.TreeSet;

/**
 *  将字符串中的数值排序
 * 		例如String str="8 10 15 5 2 7";---->"2 5 7 8 10 15"
 */
public class MyDemo6 {
	public static void main(String[] args) {
		String str="8 10 15 5 2 7";
		str=sout(str);
		System.out.println(str);
	}

	private static String sout(String str) {
		StringBuilder sBuilder=new StringBuilder();
		String[] arr=str.split(" ");
		TreeSet treeSet=new TreeSet();
		for (int i = 0; i < arr.length; i++) {
//			Integer integer=new Integer(arr[i]);
			Integer integer=Integer.parseInt(arr[i]);//字符串转int方法
			treeSet.add(integer);
		}
		Iterator it=treeSet.iterator();
		while(it.hasNext()){
			sBuilder.append(it.next()+" ");
		}
		return sBuilder.toString();
	}
	
}
