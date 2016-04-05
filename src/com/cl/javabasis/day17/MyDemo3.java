package com.cl.javabasis.day17;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
	迭代：
		keySet() 
		values() 
		entrySet() 
 */
public class MyDemo3 {
	public static void main(String[] args) {
		Map<String, String> map=new HashMap<String, String>();
		//添加方法
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		map.put("ddd", "333");
		
		//map集合中遍历方式一： 使用keySet方法进行遍历		 缺点： keySet方法只是返回了所有的键，没有值
//		Set<String> keys=map.keySet();//keySet() 把Map集合中的所有键都保存到一个Set类型 的集合对象中返回。
//		Iterator<String> it=keys.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
		
		//map集合的遍历方式二： 使用values方法进行			缺点： values方法只能返回所有 的值，没有键。
//		Collection<String> c=map.values();// 把所有的值存储到一个Collection集合中返回。
//		Iterator<String> it2=c.iterator();
//		while(it2.hasNext()){
//			System.out.println(it2.next());
//		}
		
		//map集合的遍历方式三： entrySet方法遍历。
		Set<Entry<String, String>> entrys=map.entrySet();
		Iterator<Entry<String,String>> it=entrys.iterator();
		while(it.hasNext()){
			Entry<String, String> entry=it.next();
			System.out.println(entry);
			System.out.println("键："+entry.getKey()+",值："+entry.getValue());
		}
	}
}
