package com.cl.javabasis.day15list;
import java.util.ArrayList;
import java.util.List;

/**
 * -------| Collection  单例集合的跟接口。 
----------| List  如果是实现了List接口的集合类，具备的特点： 有序，可重复。
----------| Set   如果是实现了Set接口的集合类，具备特点： 无序，不可重复
	
	有序：集合的有序不是指自然顺序，而是指添加进去的顺序与元素出来的顺序是一致的
	
	List特有的方法
		添加		
			add(Object object)
		 	addAll(Collection<? extends E> c)  
		 获取
		 	 get(int index)  
		 	 indexOf(Object o) 
		 	 lastIndexOf(Object o) 
		 	 subList(int fromIndex, int toIndex) 
		 修改
		 	set(int index, E element) 
		 	
 */
public class MyDemo1 {
	public static void main(String[] args) {
		List list=new ArrayList();
		list.add("小明");
		list.add("小红");
		list.add("小白");
		list.add("小黑");
		list.add("小黑");
		
		System.out.println("集合的元素"+list);
	}
}
