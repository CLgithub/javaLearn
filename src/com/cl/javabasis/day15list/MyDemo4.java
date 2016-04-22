package com.cl.javabasis.day15list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * 迭代器在遍历的时候要注意的事项
 * 在迭代器迭代元素的过程中(迭代器创建到使用结束，就不允许集合对象……)，不允许使用集合对象改变集合中的元素个数，如果需要添加或删除
 * 只能使用迭代器的方法进行操作
 * 如果使用了集合对象改变了集合中的元素个数，就会出现ConcurrentModificationException异常
 */
public class MyDemo4 {

	public static void main(String[] args) {
		List list=new ArrayList();
		list.add("小明");
		list.add("小红");
		list.add("小白");
		list.add("小黑");
		
		ListIterator it=list.listIterator();	//一旦创建了迭代器
		
		it.add("aa");							//只能用it对象去添加或删除集合元素，
									//it.add()把元素添加到指针当前指向的位置，指针向下移动一个位置
		
//		list.add("aa");							//就不允许list对象再去添加或删除集合对象
//		list.remove(2);
		System.out.println(it.hasNext());
		System.out.println(it.hasPrevious());
		it.next();								//否则it就会报错
		it.previous();
		
		
		
		
		
		System.out.println("\r\n集合的元素："+list);
	}
	
}
