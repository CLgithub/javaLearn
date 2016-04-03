package com.cl.javabasis.day15list;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 集合的体系：
 * ------------|Collection	单列集合的根接口
 * ------------------|List	如果实现了List接口的集合类，有序，可重复
 * -----------------------|ArrayList	ArrayList底层是维护了一个Object数组实现的，特点：查询快，增删慢
 * 											什么时候使用ArrayList:如果目前的数据是查询比较多，增删比较少的时候，比如：高校的图书馆
 * -----------------------|LinkedList	ListkedList底层使用了链表数据结构实现的，特点：查询慢，增加快
 * -----------------------|Vector(了解)
 * 
 * ------------------|Set	如果实现了Set接口的集合类，无序，不可重复
 * 
 * 
 * ArrayList 特有的方法
 * 		ensureCapacity(int minCapacity) 
 * 		trimToSize() 
 * 
 * 
 * 笔试题目：使用ArrayList的无参构造函数创建一个对象是，默认容量是多少？如果长度不够使用时又自动增长多少？
 * 		ArrayList底层是维护了一个Object数组实现的，使用无参构造函数是，object数组默认容量是10，当长度不够时，自动增长0.5倍
 * 
 * 
 * LinkedList 常用特有的方法
 * 		1：方法介绍
            addFirst(E e) 把元素添加到集合的首位置上
			addLast(E e) 把元素添加到集合的末尾
			getFirst() 
			getLast() 
			removeFirst() 
			removeLast() 
				如果集合中没有元素，获取或者删除元
				素抛：NoSuchElementException
		2：数据结构
			1：栈 （1.6）：主要是用于实现（模拟）堆栈数据结构的存储方式
				先进后出
				push() //将元素push到栈中（将元素插入到集合的开头出）
				pop()
			2：队列（双端队列1.5）：主要是为了可以使用linkedList模拟队列数据结构的存储方式
				先进先出
				offer()
				poll()
		3：返回逆序的迭代器对象      
				descendingIterator()   返回逆序的迭代器对象
 * 
 */
public class MyDemo7 {
	public static void main(String[] args) {
		LinkedList<String> list=new LinkedList();
		list.add("小明");
		list.add("小红");
		list.add("小白");
		list.add("小黑");
		
//		list.addFirst("aa");//把元素添加到集合的首位置上
//		list.addLast("bb");//把元素添加到集合的末尾
		
//		System.out.println("获取集合的首位置元素："+list.getFirst());
//		System.out.println("获取集合的末尾位置元素："+list.getLast());
		
//		System.out.println("删除集合首位置元素并返回"+list.removeFirst());
//		System.out.println("删除集合末尾位置元素并返回"+list.removeLast());
		
//		list.push("aa");		//将元素push到栈中（将元素插入到集合的开头出）
//		System.out.println("适合的首元素是:"+list.pop());				//移除并返回集合中的第一个元素
		
		list.offer("aa");		//将元素加到集合的末尾处
		System.out.println("删除集合的首位置元素并返回："+list.poll());			//
		
		System.out.println(list);
		
		//逆向迭代器
//		Iterator it=list.descendingIterator();
//		while (it.hasNext()){
//			System.out.println(it.next());
//		}
	}
}
