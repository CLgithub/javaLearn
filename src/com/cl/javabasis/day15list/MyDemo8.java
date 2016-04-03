package com.cl.javabasis.day15list;

import java.util.LinkedList;

/**
 * 数据结构
	1：栈 （1.6）：主要是用于实现（模拟）堆栈数据结构的存储方式
		先进后出
		push() 		//将元素插入到集合首位置（将元素push到栈中）
		pop()		//移除并返回集合中的首位置元素
		
	2：队列（双端队列1.5）：主要是为了可以使用linkedList模拟队列数据结构的存储方式
		先进先出
		offer()		//将元素加到集合的末尾处
		poll()		//移除集合的首位置元素并返回
		
	机试题目：使用LinkedList实现堆栈结构的存储方式与队列的数据结构存储方式
 */
public class MyDemo8 {
	public static void main(String[] args) {
		/*StackList stackList=new StackList();
		stackList.add("小明");
		stackList.add("小红");
		stackList.add("小白");
		stackList.add("小黑");
		
//		System.out.println(stackList.pop());
//		System.out.println(stackList.pop());
//		System.out.println(stackList.pop());
		int size=stackList.size();
		for (int i = 0; i < size;i++) {
			System.out.println(stackList.pop());
		}*/
		
		MyLinkedList myLinkedList=new MyLinkedList();
		myLinkedList.add("小明");
		myLinkedList.add("小红");
		myLinkedList.add("小白");
		myLinkedList.add("小黑");
		
		int size=myLinkedList.size();
		for (int i = 0; i < size; i++) {
			System.out.println(myLinkedList.poll());
		}
	}
}
//使用LinkedList模拟堆栈的数据结构存储方式
class StackList{
	LinkedList list;
	
	public StackList() {
		list=new LinkedList<>();
	}
	//进栈
	public void add(Object obj){
		list.push(obj);
	}
	//弹栈
	public Object pop(){
		return list.pop();
	}
	
	//获取元素个数
	public int size(){
		return list.size();
	}
}

class MyLinkedList{
	LinkedList list;
	
	public MyLinkedList() {
		list=new LinkedList();
	}
	
	public void add(Object obj){
		list.offer(obj);
	}
	
	public Object poll(){
		return list.poll();
	}
	
	//获取元素个数
	public int size(){
		return list.size();
	}
}
