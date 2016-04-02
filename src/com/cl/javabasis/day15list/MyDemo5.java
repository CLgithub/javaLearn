package com.cl.javabasis.day15list;

import java.util.ArrayList;
import java.util.List;

/**
 * 集合的体系：
 * ------------|Collection	单列集合的根接口
 * ------------------|List	如果实现了List接口的集合类，有序，可重复
 * -----------------------|ArrayList	ArrayList底层是维护了一个Object数组实现的，特点：查询快，增删慢
 * 		什么时候使用ArrayList:如果目前的数据是查询比较多，增删比较少的时候，比如：高校的图书馆
 * -----------------------|LinkedList
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
 */
public class MyDemo5 {
	public static void main(String[] args) {
		ArrayList arrayList=new ArrayList();
//		arrayList.add("a");
		arrayList.ensureCapacity(20);//一般用构造方法指定
		System.out.println(""+arrayList.size());
	}
}
