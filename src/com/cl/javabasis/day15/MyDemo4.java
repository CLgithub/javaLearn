package com.cl.javabasis.day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Collection 单例集合的根接口
 * 迭代
		toArray() 
		iterator() 
		迭代器的作用，抓取集合中的元素
		
		迭代器的方法：
			hasNext()	当前指针是否有指向元素，如果有元素可以返回true，否则返回false
			
			next()	取出元素
			
			remove()	移除迭代器最后一次返回的元素
 * 	
 */
public class MyDemo4 {
	public static void main(String[] args) {
		Collection c=new ArrayList();
		c.add(new Person(1, "小明"));
		c.add(new Person(2, "小白"));
		c.add(new Person(3, "小黑"));
		c.add(new Person(4, "小红"));
		
		//遍历集合的元素---------->方式一：toArray()
//		Object[] arr=c.toArray();//把集合的元素存储到一个object的数组中去返回
//		System.out.println(Arrays.toString(arr));
		
		//要求使用迭代器iterator遍历
		Iterator it=c.iterator();//返回一个迭代器	疑问：iterator()返回一个接口，为什么接口有可以调用方法可以使用呢？实际返回的是接口的实现类
//		System.out.println("有元素可以遍历吗"+it.hasNext());
//		System.out.println("获取元素"+it.next());
//		System.out.println("获取元素"+it.next());
//		System.out.println("获取元素"+it.next());
//		System.out.println("获取元素"+it.next());
////		System.out.println("获取元素"+it.next());//NoSuchElementException	没有元素的异常
//		System.out.println("有元素可以遍历吗"+it.hasNext());
		
//		while (it.hasNext()){
//			System.out.println(it.next());
//		}
		//Iterator it=c.iterator();得到迭代器，迭代器中有一个指针指向集合中的第一个元素
		//it.hasNext()	当前指针是否有指向元素，有返回true，没有返回false，看源码一句就可以实现cursor != size;
		//it.next()		获取当前指针指向的元素并返回当前元素，然后指针向下移动一个单元
		
		it.next();
		it.next();
		it.remove();//除以迭代器最后一次返回的元素，
		
		//相当于清空c
//		while (it.hasNext()){
//			it.next();
//			it.remove();
//		}
		System.out.println("集合的元素是："+c);
	}
}
