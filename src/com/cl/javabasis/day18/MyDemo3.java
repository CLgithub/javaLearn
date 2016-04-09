package com.cl.javabasis.day18;

import java.util.Iterator;

public class MyDemo3 {
	public static void main(String[] args) {
		Mylist<String> mylist=new Mylist<String>();
		mylist.add("小明");
		mylist.add("小红");
		mylist.add("小黑");
		mylist.add("小白");
		for (String str:mylist) {
			System.out.println(str);
		}
		
		Mylist<Integer> mylist2=new Mylist<>();
		mylist2.add(2);
		mylist2.add(4);
		mylist2.add(3);
		Iterator<Integer> it=mylist2.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
//自定义类使用增强for循环
class Mylist<T> implements Iterable<T>{
	Object[] arr=new Object[10];
	
	int index=0;//当前指针
	
	int cusor=0;
	
	public void add(Object o){
		arr[index++]=o;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			@Override
			public boolean hasNext() {
				return cusor<index;
			}

			@Override
			public T next() {
				return  (T) arr[cusor++];
			}
		};
	}

	
}
