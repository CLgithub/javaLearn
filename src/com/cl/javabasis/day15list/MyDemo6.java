package com.cl.javabasis.day15list;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ArrayList练习
 * 需求：编写一个函数清除集合中的重复元素，如果书号一样就视为重复元素，要求遍历集合元素的时候必须使用迭代器
 */
public class MyDemo6 {
	public static void main(String[] args) {
		ArrayList list=new ArrayList();
		list.add(new Book(110,"java编程思想"));
		list.add(new Book(220,"java核心技术"));
		list.add(new Book(330,"深入javaWeb"));
		list.add(new Book(110,"java神书"));
		
		ArrayList list2=method1(list);
		System.out.println("去重后："+list2);
//		System.out.println(new Book(110,"java神书").equals(new Book(110,"java编程思想")));
	}

	private static ArrayList method1(ArrayList list) {
		ArrayList list2=new ArrayList();
		Iterator it=list.iterator();
		while(it.hasNext()){
			Book book=(Book) it.next();
			if(!list2.contains(book)){
				list2.add(book);
			}
		}
		return list2;
	}
	
	
}

class Book {
	private int id;
	private String name;

	public Book(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Book book=(Book) obj;
		return this.id==book.id;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + "]";
	}
	
	

}
