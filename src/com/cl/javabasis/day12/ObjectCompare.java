package com.cl.javabasis.day12;

/**
 * 对象的比较，现在总是混
 * @author L
 * @date 2016年6月5日
 */
public class ObjectCompare {
	public static void main(String[] args) {
		test1();
//		test2();
	}

	public static void test1() {
		String str1 = "hello";
		String str2 = "hello";
		String str3 = new String("hello");
		String str4 = new String("hello");
		
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));

		System.out.println(str1 == str3);
		System.out.println(str1.equals(str3));

		System.out.println(str3 == str4);
		System.out.println(str3.equals(str4));
	}

	public static void test2() {
		Obj obj1=new Obj();
		Obj obj2=new Obj();
		Obj obj3=obj1;
		
		System.out.println(obj1==obj2);
		System.out.println(obj1.equals(obj2));
		
		System.out.println(obj1==obj3);
		System.out.println(obj1.equals(obj3));
		
		System.out.println(obj2==obj3);
		System.out.println(obj2.equals(obj3));
	}
}

class Obj {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Obj [name=" + name + "]";
	}

	public Obj(String name) {
		this.name = name;
	}

	public Obj() {
	}

}