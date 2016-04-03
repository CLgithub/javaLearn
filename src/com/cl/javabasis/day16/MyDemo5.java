package com.cl.javabasis.day16;

import java.util.TreeSet;
/**
 * TreeSet是可以对字符串排序的，因为String类已经实现了Comparable接口
 * 字符串比较规则
 * 		对应位置比较，空<a<b……z
 * 
 */
public class MyDemo5 {
	public static void main(String[] args) {
		TreeSet treeSet=new TreeSet();
		treeSet.add("abccc");
		treeSet.add("abw");
		treeSet.add("abwc");
		System.out.println(treeSet);
		System.out.println("abccc".compareTo("abw"));
	}
}
