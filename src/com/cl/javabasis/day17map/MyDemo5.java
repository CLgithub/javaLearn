package com.cl.javabasis.day17map;

import java.util.Comparator;
import java.util.TreeMap;

/*
双列集合：
--------| Map<K,V> 根接口，特点：存储的数据都是以键值对形式存在的，键不可重复，值可以重复
------------| HashMap 底层也是基于哈希表实现的
	HashMap存储原理：（和HashSet类似）
		往HashMap添加元素的时候，首先会调用键的hashCode方法得到元素的哈希码值，如果经过运算就可以算出该元素在哈希表中的存储位置
		情况1：如果该位置没有存储元素，则存在该位置，情况2：如果算出的位置已经有其他元素，会调用该元素的equals方法与位置上的元素都比较，
		如果equals方法返回false，就存在该位置，如果返回true，就视为重复元素，不允许存储
------------| TreeMap 底层也是基于二叉树数据机构实现的，特点：会对元素的键镜像排序存储
	TreeMap要注意的事项：
		1.往TreeMap添加元素的时候，如果元素的键具备自然顺序，那么就按照键的自然顺序特性进行排序存储。
		2.往TreeMap添加元素的时候，如果元素的键不具备自然顺序，那么元素的键所属的类必须要实现Comparable接口，把比较规则定义在comparaTo方法中
		3.往TreeMap添加元素的时候，如果元素的键不具备自然顺序，而且元素的键所属的类也没有实现Comparable接口，那么就必须在创建TreeMap的时候传入一个自定义比较器

------------| HashTable (了解，jdk1.0) 底层也是依赖了哈希表实现的，实现方式与HashMap是一致的，但是他是线程安全的，操作效率低
 * */
public class MyDemo5 {
	public static void main(String[] args) {
//		TreeMap<Character, Integer> treeMap=new  TreeMap<Character,Integer>();
//		treeMap.put('c', 10);
//		treeMap.put('a', 1);
//		treeMap.put('e', 6);
//		treeMap.put('d', 4);
//		treeMap.put('b', 7);
//		System.out.println(treeMap);
		
//		TreeMap<Emp, String> treeMap=new TreeMap<>();
//		treeMap.put(new Emp("小明", 2000), "001");
//		treeMap.put(new Emp("小红", 1000), "002");
//		treeMap.put(new Emp("小黑", 1500), "003");
//		treeMap.put(new Emp("小白", 4000), "004");
//		System.out.println(treeMap);
		
		TreeMap<Emp2, String> treeMap=new TreeMap<>(new MyComparator());
		treeMap.put(new Emp2("小明", 2000), "001");
		treeMap.put(new Emp2("小红", 1000), "002");
		treeMap.put(new Emp2("小黑", 1500), "003");
		treeMap.put(new Emp2("小白", 4000), "004");
		treeMap.put(new Emp2("小李", 4000), "005");
		System.out.println(treeMap);
	}
}
class Emp implements Comparable<Emp>{
	String name;
	int salary;
	public Emp(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "[name=" + name + ", salary=" + salary + "]";
	}
	@Override
	public int compareTo(Emp o) {
		return this.salary-o.salary;
	}
}


class Emp2{
	String name;
	int salary;
	public Emp2(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "[name=" + name + ", salary=" + salary + "]";
	}
	
}
class MyComparator implements Comparator<Emp2>{
	@Override
	public int compare(Emp2 o1, Emp2 o2) {
		return o1.salary-o2.salary;
	}
}

