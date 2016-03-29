package com.cl.javabasis.day15;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 判断
		isEmpty() //是否为空
		contains(Object o) //包含
		containsAll(Collection<?> c) 
 */
public class MyDemo2 {
	public static void main(String[] args) {
		/*Collection c=new ArrayList();
		c.add("aaa");
		c.add("bbb");
		c.add("ccc");
		
		System.out.println("判断集合是否为空："+c.isEmpty());
		System.out.println("判断是否存在指定的元素"+c.contains("aaa"));*/
		
		/**
		 * 添加自定义的元素
		 */
		Collection c=new ArrayList();
		c.add(new Person(1, "小明"));
//		Person person=new Person(2, "小白");
		c.add(new Person(2, "小白"));
		c.add(new Person(3, "小黑"));
		c.add(new Person(4, "小红"));
		
		
		Collection c2=new ArrayList();
		c2.add(new Person(2, "小白"));
		c2.add(new Person(3, "小黑"));
		
		System.out.println("c集合有包含c2集合中的所有元素吗："+c.containsAll(c2));
		
		c.contains(new Dog());//看源码，用的是Dog的equals方法
		//如果在现实生活中，只要身份证编号一致，那么就为同一个人
		//通过看源码，contains方法内部是依赖equals方法比较的
		System.out.println("存在该元素吗"+c.contains(new Person(2, "小白1")));
		System.out.println(c);
	}
}
class Person{
	int id;
	String name;
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [编号=" + id + ", 姓名=" + name + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		Person person=(Person) obj;
		if(person.id==this.id){
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * java规范，一般重写了equals方法，都会重写hashCode
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
}

class Dog{
	
}
