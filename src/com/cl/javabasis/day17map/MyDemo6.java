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
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM"); 
		TreeMap<Book, String> treeMap=new TreeMap<>(new MyComparable());
		treeMap.put(new Book("java就业培训教材", sdf1.parse("2001-09")), "001");
		treeMap.put(new Book("数据库学习", sdf1.parse("2011-09")), "002");
		treeMap.put(new Book("零基础XXXXX", sdf1.parse("2006-09")), "003");
		treeMap.put(new Book("PHPXXXXX", sdf1.parse("2003-09")), "004");
		System.out.println(treeMap);
	}
}
class Book{
	String name;
	Date date;//出版日期
	@Override
	public String toString() {
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM");
		return "[name=" + name + ", date=" + sdf1.format(date) + "]";
	}
	public Book(String name, Date date) {
		this.name = name;
		this.date = date;
	}
}
class MyComparable implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM"); 
		return sdf1.format(o1.date).compareTo(sdf1.format(o2.date));
	}
	
}