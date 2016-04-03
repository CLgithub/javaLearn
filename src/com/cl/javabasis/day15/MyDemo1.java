package com.cl.javabasis.day15;

import java.util.ArrayList;
import java.util.Collection;

/**
集合：集合是存储对象数据的集合容器。

集合比数组的优势：
	1. 集合可以存储任意类型的对象数据，数组只能存储同一种数据类型 的数据。
	2. 集合的长度是会发生变化的，数组的长度是固定的。
	

-------| Collection  单例集合的跟接口。 
----------| List  如果是实现了List接口的集合类，具备的特点： 有序，可重复。
----------| Set   如果是实现了Set接口的集合类，具备特点： 无序，不可重复。

Collection接口中的方法：
	
	增加
		add(E e)  添加成功返回true，添加 失败返回false.
		addAll(Collection c)  把一个集合 的元素添加到另外一个集合中去。
	删除
		clear() 
		remove(Object o) 
		
		removeAll(Collection  c) 
		retainAll(Collection  c) 
	查看
		size() 
	判断
		isEmpty() //是否为空
		contains(Object o) //包含
		containsAll(Collection<?> c) 
	迭代
		toArray() 
		iterator() 
*/
public class MyDemo1 {
	public static void main(String[] args) {
		Collection c=new ArrayList();
		c.add("aaa");
		c.add("bbb");
//		System.out.println("添加成功吗？"+c.add("ccc"));
		
		Collection c2=new ArrayList<>();
		c2.add("ddd");
		c2.add("eee");
		c2.add("aaa");
		c.addAll(c2);
		System.out.println(c2);
		
		
		/**
		 * 删除方法
		 */
//		c.clear();//清空集合中的元素
		System.out.println(c.remove("aa"));//指定集合中的元素进行删除，删除成功true，失败false
//		c.removeAll(c2);//删除c集合中与c2的交集的元素
		
		c.retainAll(c2);//保留c集合中与c2的交集元素 
		
		/**
		 * 查看
		 */
		System.out.println("元素个数："+c.size());
		
		System.out.println(c);
	}
}
