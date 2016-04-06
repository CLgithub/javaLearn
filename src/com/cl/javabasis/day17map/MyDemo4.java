package com.cl.javabasis.day17map;

import java.util.HashMap;

/*
双列集合：
--------| Map<K,V> 根接口，特点：存储的数据都是以键值对形式存在的，键不可重复，值可以重复
------------| HashMap 底层也是基于哈希表实现的
	HashMap存储原理：（和HashSet类似）
		往HashMap添加元素的时候，首先会调用键的hashCode方法得到元素的哈希码值，如果经过运算就可以算出该元素在哈希表中的存储位置
		情况1：如果该位置没有存储元素，则存在该位置，情况2：如果算出的位置已经有其他元素，会调用该元素的equals方法与位置上的元素都比较，
		如果equals方法返回false，就存在该位置，如果返回true，就视为重复元素，不允许存储
------------| TreeMap 底层也是基于二叉树数据机构实现的，特点：会对元素的键镜像排序存储
------------| HashTable
 * */
public class MyDemo4 {
	public static void main(String[] args) {
		HashMap<Person, String> map=new HashMap<Person,String>();
		map.put(new Person(110, "小明"), "001");
		map.put(new Person(220, "小红"), "002");
		map.put(new Person(440, "小白"), "007");
		map.put(new Person(110, "小明"), "003");//如果出现了相同的键，那么后添加的值会取代之前的值
		System.out.println(map);
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
		return "[id=" + id + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		return this.id;
	}
	@Override
	public boolean equals(Object obj) {
		Person parser=(Person) obj;
		return this.id==parser.id;
	}
	
}
