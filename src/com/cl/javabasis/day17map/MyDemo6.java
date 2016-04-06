package com.cl.javabasis.day17map;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.TreeMap;

/**
需求：自定义一个TreeMap，键存储的是书对象，值存储的是字符串，根据书的出版日期排序

 */
public class MyDemo6 {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd"); 
		TreeMap<Book, String> treeMap=new TreeMap<>(new MyBookComparable());
		treeMap.put(new Book("书1", sdf1.parse("2001-09-21")), "001");
		treeMap.put(new Book("书2", sdf1.parse("2012-09-13")), "002");
		treeMap.put(new Book("书3", sdf1.parse("2003-08-06")), "003");
		treeMap.put(new Book("书4", sdf1.parse("2014-08-16")), "004");
		System.out.println(treeMap);
	}
}
class Book{
	String name;
	Date date;//出版日期
	@Override
	public String toString() {
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd"); 
		return "[name=" + name + ", date=" + sdf1.format(date) + "]";
	}
	public Book(String name, Date date) {
		this.name = name;
		this.date = date;
	}
}
class MyBookComparable implements Comparator<Book>{

//	方法一，利用String对象compareTo方法
//	@Override
//	public int compare(Book o1, Book o2) {
//		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd"); 
//		return sdf1.format(o1.date).compareTo(sdf1.format(o2.date));
//	}
	
//	@Override
	public int compare(Book o1, Book o2) {
//		不对,很可能是long相减强转时精度丢失
//		System.out.println(o1.toString()+o2+":"+(o1.date.getTime()-o2.date.getTime()));
//		return (int) (o1.date.getTime()-o2.date.getTime());
		
		return o1.date.compareTo(o2.date);
	}
}