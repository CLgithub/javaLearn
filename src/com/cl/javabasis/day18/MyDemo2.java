package com.cl.javabasis.day18;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/*
 增强for循环-----jdk1.5
 增强for循环的作用，简化迭代器的书写格式（注意：增强for循环的底层还是使用了迭代器遍历的）
 增强for循环的适用范围：如果是实现了Iterable接口的对象或者是数组对象都可以使用增强for循环
 增强for循环的格式：
 	for(变量数据类型    变量名: 遍历目标){
 	}
增强for循环要注意的事项：
	1. 增强for循环底层也是使用了迭代器获取的，只不过获取迭代器由jvm完成，不需要我们获取迭代器而已，所以在使用增强for循环变量元素的过程中不准使用集合
	对象对集合的元素个数进行修改。
	2. 迭代器遍历元素与增强for循环变量元素的区别：使用迭代器遍历集合的元素时可以删除集合的元素，而增强for循环变量集合的元素时，不能调用迭代器的remove方法删除元素。
	3. 普通for循环与增强for循环的区别：普通for循环可以没有变量的目标，而增强for循环一定要有变量的目标。
	4. 

 */
public class MyDemo2 {
	public static void main(String[] args) {
		HashSet<String> set=new HashSet<>();
		//添加元素
		set.add("小明");
		set.add("小红");
		set.add("小黑");
		set.add("小白");
		//使用迭代器遍历set集合
		Iterator<String> it=set.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
//		System.out.println("--------------------------");
//		//使用增强for循环遍历set集合
//		for(String str:set){
//			System.out.println(str);
////			set.remove("小明");
//		}
		
		int[] arr={12,5,6,1};
		/*for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}*/
		/*for(int i:arr){
			System.out.println(i);
		}*/
		
		//需求：在控制台打印五句hello world.	 普通for循环可以没有变量的目标，而增强for循环一定要有变量的目标。
		/*for (int i = 0; i < 5; i++) {
			System.out.println("hello world");
		}*/
		/*for(String ){
		}*/
		//注意： Map集合没有实现Iterable接口，所以map集合不能直接使用增强for循环，如果需要使用增强for循环需要借助于Collection
		HashMap<String, String> hashMap=new HashMap<>();
		hashMap.put("001", "小明");
		hashMap.put("002", "小红");
		hashMap.put("003", "小白");
		hashMap.put("004", "小黑");
		Set<Entry<String, String>> entrSet=hashMap.entrySet();
		for(Entry<String, String> entry:entrSet){
			System.out.print(entry.getKey()+"---");
			System.out.println(entry.getValue());
		}
		
	}
}
