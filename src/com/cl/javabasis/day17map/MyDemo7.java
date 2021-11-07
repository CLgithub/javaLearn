package com.cl.javabasis.day17map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
集合的工具类（Collections）

笔试题：说出Collection与Collections的区别
	1.Collection是单列集合的根接口，Collections是操作集合的工具类

Collections：常见方法：
	1，对list进行二分查找：
		前提该集合一定要有序。
		int binarySearch(list,key);
		//必须根据元素自然顺序对列表进行升级排序
		//要求list 集合中的元素都是Comparable 的子类。
		int binarySearch(list,key,Comparator);
	2，对list集合进行排序。
		sort(list); 
		//对list进行排序,其实使用的事list容器中的对象的compareTo方法
		sort(list,comaprator);
		//按照指定比较器进行排序
	3，对集合取最大值或者最小值。
		max(Collection)
		max(Collection,comparator)
		min(Collection)
		min(Collection,comparator)
	4，对list集合进行反转。
		revcerse(list);
	8，可以将不同步的集合变成同步的集合。
		Set synchronizedSet(Set<T> s)
		Map synchronizedMap(Map<K,V> m)
		List synchronizedList(List<T> list)
		
		
		
	5，对比较方式进行强行逆转。
		Comparator reverseOrder();
		Comparator reverseOrder(Comparator);
	6，对list集合中的元素进行位置的置换。
		swap(list,x,y);
	7，对list集合进行元素的替换。如果被替换的元素不存在，那么原集合不变。
		replaceAll(list,old,new);
		
	9. 如果想要将集合变数组：
		可以使用Collection 中的toArray 方法。注意：是Collection不是Collections工具类
		传入指定的类型数组即可，该数组的长度最好为集合的size。


 * */
public class MyDemo7 {
	public static void main(String[] args) {
//		ArrayList<Integer> arrayList=new ArrayList<>();
//		arrayList.add(12);
//		arrayList.add(1);
//		arrayList.add(9);
//		arrayList.add(12);
//		arrayList.add(4);
//		Collections.sort(arrayList);
//		System.out.println(arrayList);
//		System.out.println("元素的索引值是："+Collections.binarySearch(arrayList, 4));
//		System.out.println("最大值："+Collections.max(arrayList));
//		System.out.println("最小值："+Collections.min(arrayList));
//		Collections.reverse(arrayList);
//		System.out.println("反转后："+arrayList);
////		arrayList=(ArrayList<Integer>) Collections.synchronizedList(arrayList);
//		
//		System.out.println("-------------------------------------------------------------");
		
		
		//如果集合存储的是不具备自然顺序的元素，那么需要比较器
		ArrayList<MyPerson> arrayList2=new ArrayList<>();
		arrayList2.add(new MyPerson("小明", 12));
		arrayList2.add(new MyPerson("小红", 9));
		arrayList2.add(new MyPerson("小黑", 19));
		arrayList2.add(new MyPerson("小白", 12));
		Collections.sort(arrayList2,new AgeComparator());
		System.out.println(arrayList2);
		System.out.println("元素的索引值是："+Collections.binarySearch(arrayList2, new MyPerson("XX", 19),new AgeComparator()));
		System.out.println("最大值："+Collections.max(arrayList2,new AgeComparator()));
		System.out.println("最小值："+Collections.min(arrayList2,new AgeComparator()));
		Collections.reverse(arrayList2);
		System.out.println("反转后："+arrayList2);
	}
}

class MyPerson{
	String name;
	int age;
	public MyPerson(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "[name=" + name + ", age=" + age + "]";
	}
}
class AgeComparator implements Comparator<MyPerson>{

	@Override
	public int compare(MyPerson o1, MyPerson o2) {
		return o1.age-o2.age;
	}
	
}
