package com.cl.javabasis.day12;

import java.util.Arrays;

public class MyDemo1 {
	public static void main(String[] args) {
//		Object object=new Object();
//		//toString() 返回对象的描述信息   java.lang.Object@de6ced   类名@哈希码值的十六进制形式。
//		System.out.println(object.toString());
//		//直接输入一个对象的时候，会调用对象的toString方法。
//		System.out.println(object);
		
		Person person1=new Person("小明",21);
//		System.out.println(person.toString());
//		System.out.println(person);
		
		Person person2=new Person("小明",21);
		
		System.out.println(person1.equals(person2));
		System.out.println("person1:"+person1.hashCode());
		System.out.println("person2:"+person2.hashCode());
	}

	static class Person{
		private String name;
		private int age;
		
		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String toString() {
//			super.toString();
			return "Person [name=" + name + ", age=" + age + "]";
		}
		
		@Override
		public boolean equals(Object obj) {
			return this.name==((Person) obj).name;
		}
		
//		@Override
//		public int hashCode() {
//			return this.age;
//		}
		

	}
	
}
