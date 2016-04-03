package com.cl.javabasis.day16;

import java.util.Vector;

/**
 * 集合的体系：
 * ------------|Collection	单列集合的根接口
 * ------------------|List	如果实现了List接口的集合类，有序，可重复
 * -----------------------|ArrayList	ArrayList底层是维护了一个Object数组实现的，特点：查询快，增删慢
 * 											什么时候使用ArrayList:如果目前的数据是查询比较多，增删比较少的时候，比如：高校的图书馆
 * -----------------------|LinkedList	ListkedList底层使用了链表数据结构实现的，特点：查询慢，增加快
 * -----------------------|Vector(了解)	底层也是维护了一个object的数组实现的，与arraylist是一样的，但是Vector是线程安全的，操作效率低
 * 
 * ------------------|Set	如果实现了Set接口的集合类，无序，不可重复
 * 
 * 笔试题目：说出arraylist月Vector的区别
 * 		相同点：都是使用Object数组实现的
 * 		不同点：
 * 			1.ArrayList是线程不同步的，操作效率高，Vector是线程同步的，操作效率低。
 * 			2.ArrayList是JDK1.2出现的，Vector是jdk1.0出现的
 * 
 */
public class Mydemo1 {
	public static void main(String[] args) {
		Vector vector=new Vector();
		//添加
	}
}
