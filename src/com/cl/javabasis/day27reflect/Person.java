package com.cl.javabasis.day27reflect;

public class Person{
	private int id;
	String name;
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public Person() {
	}
	
	public void eat(int num) {
		System.out.println(name+"吃很"+num+"斤饭");
	}
	
	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + "]";
	}
	
	private static void sleep(int num) {
		System.out.println("明天睡上"+num+"小时");
	}
	
	public void sum(int[] arr) {
		System.out.println("长度是："+arr.length);
	}
	
}