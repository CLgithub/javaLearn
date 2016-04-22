package com.cl.javabasis.day15list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 迭代
 * listIterator() 
 * 
 * listIterator()特有的方法
 * 		添加：
 * 
 * 		hasPrevious()//判断是否存在上一个元素
 * 		previous()  //获取上一个元素,原来：当前指针先向上移动一个单位，然后再取出当前指针的元素
 * 					而next()是先取，再向下移
 * 
 * 		add（E）	//把当前元素插入到当前指针指向的位置上去
 * 		set(E e) //替换迭代器最后一次返回的元素
 * 		
 * 	练习：使用三种方式遍历集合的元素
 * 		一：使用get
 * 		二：使用迭代器正向遍历
 * 		三：使用迭代器逆向遍历
 */
public class MyDemo3 {
	public static void main(String[] args) {
		List list=new ArrayList();
		list.add("小明");
		list.add("小红");
		list.add("小白");
		list.add("小黑");
		
		ListIterator it=list.listIterator();//返回的是一个list接口中特有的迭代器
//		System.out.println("有上一个元素吗？"+it.hasPrevious());
//		System.out.println("获取上一个元素："+it.previous());
		
//		it.next();
//		System.out.println(it.previous());
		
//		while(it.hasNext()){
//			System.out.println("next:"+it.next());
//			System.out.println("元素："+it.previous());
//		}
		
//		while (it.hasNext()){//当前指向的位置是否有元素
//			it.next();		//先取出指针指向的元素再向下移动
//		}
//		while(it.hasPrevious()){//指针当前位置的上一个位置是否有元素
//			System.out.println("元素："+it.previous());//先向上移动，后取出指针指向的元素
//		}
		
//		it.next();
//		it.next();
//		it.add("小X");
		
//		it.next();
//		it.next();
//		it.set("X");
//		
//		System.out.println("集合的元素"+list);
		
		/**练习：使用三种方式遍历集合的元素
 * 		一：使用get
 * 		二：使用迭代器正向遍历
 * 		三：使用迭代器逆向遍历*/
//		for (int i = 0; i < list.size();i++) {
//			System.out.println(list.get(i));
//		}
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
//		while(it.hasNext()){
//			it.next();
//		}
//		while(it.hasPrevious()){
//			System.out.println(it.previous());
//		}
		
		/*
		 * ListIterator it=list.listIterator();得到一个指针，指向第一个元素
		 * it.hasNext()		指针指向的位置是否有元素，如果有true，没有false
		 * it.next()		先取出指针指向的元素，指针向下移动
		 * it.hasPrevious()		指针指向的位置的上一个位置是否有元素，如果有true，没有false
		 * it.previous()		指针先向上移动，再取出指针指向的元素
		 * 
		 * */
		
		
	}
}
