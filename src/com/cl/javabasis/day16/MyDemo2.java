package com.cl.javabasis.day16;

import java.util.HashSet;
import java.util.Set;

/**
 * 集合的体系：
 * ------------|Collection	单列集合的根接口
 * ------------------|List	如果实现了List接口的集合类，有序，可重复
 * -----------------------|ArrayList	ArrayList底层是维护了一个Object数组实现的，特点：查询快，增删慢
 * -----------------------|LinkedList	ListkedList底层使用了链表数据结构实现的，特点：查询慢，增加快
 * -----------------------|Vector(了解) 底层也是维护了一个object的数组实现的，与arraylist是一样的，但是Vector是线程安全的，操作效率低
 * 
 * ------------------|Set	如果实现了Set接口的集合类，无序，不可重复
 * 								添加元素的顺序和出来元素的顺序不一样
 * -----------------------|HashSet	底层是使用哈希表来支持的，特点：存储快
							hashSet的实现原理：
								往Haset添加元素的时候，HashSet会先调用元素的hashCode方法得到元素的哈希值 ，
								然后通过元素 的哈希值经过移位等运算，就可以算出该元素在哈希表中 的存储位置。
								情况1： 如果算出元素存储的位置目前没有任何元素存储，那么该元素可以直接存储到该位置上。
								情况2： 如果算出该元素的存储位置目前已经存在有其他的元素了，那么会调用该元素的equals方法与该位置的元素再比较一次
								，如果equals返回的是true，那么该元素与这个位置上的元素就视为重复元素，不允许添加，如果equals方法返回的是false，那么该元素运行 添加。
 * -----------------------|TreeSet
 */
public class MyDemo2 {
	public static void main(String[] args) {
		Set set=new HashSet();
//		set.add("小明");
//		set.add("小红");
//		set.add("小白");
//		set.add("小黑");
//		System.out.println("添加成功吗?"+set.add("小黑"));
		
		set.add(new Person(110, "小明"));
		set.add(new Person(220, "小红"));
		set.add(new Person(330, "小白"));
		//只要编号一致，就为同一个人
		System.out.println("添加成功吗？"+set.add(new Person(110, "小黑")));
		System.out.println(set);
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
		return "[编号=" + id + ", 姓名=" + name + "]";
	}
	

	@Override
	public int hashCode() {
//		System.out.println("hashCode()");
		return this.id;
	}
	
	@Override
	public boolean equals(Object obj) {
//		System.out.println("equals()");
		Person person=(Person) obj;
		return person.id==this.id;
	}
	
}

