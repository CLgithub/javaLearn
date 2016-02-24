package com.cl.learn.api;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableTest {
	public static void main(String[] args) {
		Hashtable numbers=new Hashtable();
		Mykey mykey1=new Mykey("zs", 18);
		numbers.put(mykey1, new Integer(1));
		numbers.put(new Mykey("ls", 15), new Integer(2));
		numbers.put(new Mykey("ww", 20), new Integer(3));
		
		Integer integer=(Integer) numbers.get(mykey1);
//		System.out.println(integer);
		Enumeration e=numbers.keys();
		while(e.hasMoreElements()){
			Mykey key=(Mykey) e.nextElement();
			System.out.print(key.toString()+"=");
			System.out.println(numbers.get(key).toString());
		}
	}
}
