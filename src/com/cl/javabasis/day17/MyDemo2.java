package com.cl.javabasis.day17;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
在现实生活中有些数据是以映射关系存在的，也就是成对存在的
	如：身份证		人
		一把钥匙		锁

双列集合：
--------| Map<K,V> 根接口，特点：存储的数据都是以键值对形式存在的，键不可重复，值可以重复
------------| HashMap 无序
------------| TreeMap
------------| HashTable

Map接口的方法：
	增删:
		V put(K key, V value)  //添加键值，返回以前与 key 关联的值，如果没有针对 key 的映射关系，则返回 null
		void putAll(Map<? extends K,? extends V> m) 
	 	void clear()  //删除
	 	V remove(Object key)  
	获取：
		V get(Object key) 
		int size()   
	判断：
		boolean containsKey(Object key)  
		boolean containsValue(Object value) 
		boolean isEmpty()   
	 迭代：
	 	Set<Map.Entry<K,V>> entrySet()  
	 	Set<K> keySet()  
	 	Collection<V> values()  

 */
public class MyDemo2 {
	public static void main(String[] args) {
		Map<String, String> map=new HashMap<String, String>();
		//添加方法
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
//		System.out.println("返回是："+map.put("ccc", "444"));//如果已经存在该键，就返回该键对应的值
//		System.out.println("返回是："+map.put("ddd", "444"));//如果之前没有存在该键，返回null
//		
//		Map<String, String> map2=new HashMap<String, String>();
//		map2.put("小明", "xiaoming");
//		map2.put("小红", "xiaohong");
//		
//		map.putAll(map2);//把map2添加到map中
//		System.out.println("集合的元素是："+map);
		
		//删除方法
//		System.out.println("删除的数据是："+map.remove("aaa"));//根据键，删除map中的数据，返回该键对应的值
//		System.out.println("删除的数据是："+map.remove("a"));
//		System.out.println("集合的元素是："+map);
//		map.clear();//情况集合中的元素
//		System.out.println("集合的元素是："+map);
		
		//获取方法
//		System.out.println("根据指定的键，获得对应的值:"+map.get("aaa"));
//		System.out.println("获取map集合中的键值对个数："+map.size());
		
		//判断方法
//		System.out.println("判断map集合是否包含指定的键："+map.containsKey("aaa"));
//		System.out.println("判断map集合是否包含指定的值："+map.containsValue("333"));
//		map.clear();
//		map.put(null, null);//这样也行
//		System.out.println("判断map集合元素是否为空"+map.isEmpty());
		
		System.out.println("集合的元素是："+map);
	}
}
