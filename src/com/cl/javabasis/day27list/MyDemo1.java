package com.cl.javabasis.day27list;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
 内存泄露
 
 需求：编写一个类使用数组模拟栈的存储方式
 
 栈存储特点：先进后出，后进先出

 主意：如果对象不再使用了，这时候应该不要让变量指向该对象，要让该对象尽快的被gc回收
 
 */
public class MyDemo1 {
	public static void main(String[] args) {
		StackList list=new StackList();
		list.push("小明");
		list.push("小红");
		list.push("小黑");
		list.push("小白");
		
//		System.out.println("元素个数："+list.size());
		int length=list.size();
		for(int i=0;i<length;i++){
			System.out.println(list.pop());
		}
		
		list.push("小红x");
		list.push("小黑x");
		list.push("小白x");
		
		int length2=list.size();
		for(int i=0;i<length2;i++){
			System.out.println(list.pop());
		}
	}
}
class StackList{
	Object[] elements;

	int index=0;//当前的索引值
	
	public StackList() {
		this.elements = new Object[3] ;
	}
	
	//添加内容
	public void push(Object object) {
		//添加元素之前应该要先检查一下当前容量是否后用
		ensureCapcity();
		elements[index++]=object;
	}
	
	//出栈:删除集合中的元素，并且返回别删除的元素
	public Object pop() {
		Object object=elements[--index];
		elements[index]=null;	//让该位置指向null，原来的对象赶紧被gc回收♻️
		return object;
	}
	
	//检查当前的数组是否够用
	public void ensureCapcity() {
		if(index==elements.length){
			//计算一个新的长度
			int newLength=elements.length*2;
			elements=Arrays.copyOf(elements, newLength);
		}
	}
	
	//获取当前元素个数
	public int size() {
		return index;
	}
}
