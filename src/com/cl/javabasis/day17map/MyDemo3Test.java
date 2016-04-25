package com.cl.javabasis.day17map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/*
 练习Map遍历
 */
public class MyDemo3Test {
	public static void main(String[] args) {
		HashMap<String, Integer> hashMap=new HashMap<>();
		hashMap.put("aaa", 1);
		hashMap.put("ccc", 2);
		hashMap.put("ddd", 1);
		hashMap.put("bbb", 3);
		
		System.out.println(hashMap);
		
		//遍历map
		Set<Entry<String, Integer>> set=hashMap.entrySet();
		Iterator<Entry<String, Integer>> it=set.iterator();
		while(it.hasNext()){
//			System.out.println(it.next());
			Entry<String, Integer> entry=it.next();
			System.out.print("键＝"+entry.getKey());
			System.out.println(" 值＝"+entry.getValue());
		}
	}
}
