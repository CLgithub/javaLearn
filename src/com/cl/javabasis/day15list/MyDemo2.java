package com.cl.javabasis.day15list;

import java.util.ArrayList;
import java.util.List;

/**
 * List特有的方法
		添加		
			add(int index, E element)  
		 	addAll(int index, Collection<? extends E> c)  
		 获取
		 	 get(int index)  
		 	 indexOf(Object o) 
		 	 lastIndexOf(Object o) 
		 	 subList(int fromIndex, int toIndex) 
		 修改
		 	set(int index, E element) 
		 	
	List接口中特有的方法具备的特点：操作的方法都具有索引值	 
	
	只有list接口下面的集合类才具备索引值，其他接口下面的集合类都不具有索引值
	
 */
public class MyDemo2 {
	public static void main(String[] args) {
		List list=new ArrayList();
		list.add("小明");
		list.add("小红");
		list.add("小白");
		list.add("小黑");
		list.add("小黑");//把元素添加的集合的末尾处
		
		//添加
//		list.add(1, "X");//把元素添加到指定索引值位置上
		/*
		List list2=new ArrayList<>();
		list2.add("小C");
		list2.add("小X");
		
		list.addAll(1,list2);//把list2的元素添加到list集合指定索引位置,不指定位置,则添加到末尾
		*/
		
		//获取方法
//		System.out.println("get方法获取元素："+list.get(3));
//		//使用get方法遍历集合元素
//		for (int i = 0; i < list.size(); i++) {
//			System.out.print(list.get(i)+",");
//		}
//		System.out.println();
		
//		System.out.println("找出指定元素第一次出现在集合中的索引值："+list.indexOf("小黑"));
//		System.out.println("找出指定元素第一次出现在集合中的索引值："+list.lastIndexOf("小黑"));
		
//		System.out.println("集合的元素"+list);
		list=list.subList(1, 5);//返回列表中指定的 fromIndex（包括 ）和 toIndex（不包括）之间的部分list。
		
//		list.set(3, "x");//使用指定的元素替换指定索引位置的元素
		
		System.out.println("集合的元素"+list);
	}
}
