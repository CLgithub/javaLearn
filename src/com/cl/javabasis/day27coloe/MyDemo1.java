package com.cl.javabasis.day27coloe;

/*
 对象的克隆
 	对象的浅克隆（不会克隆第二层对象）
 		要主意的细节：
 			1.如果一个对象需要调用clone的方法克隆，那么该对象所属的类必须要实现Cloneable接口
 			2.Cloneable接口只不过是一个标志接口而已，没有任何方法
 			3.对象的浅就是克隆一个对象的时候，如果被克隆的对象维护了另一个类的对象，这时候只是克隆另外一个对象的地址，而没有把另外一个对象也拷贝一份
 			4.对象的浅克隆不会调用构造方法
 			
 	对象的深克隆
 
 */
public class MyDemo1 {
	public static void main(String[] args) throws CloneNotSupportedException {
		Address address=new Address("广州");
		Person p1=new Person(110, "小明", address);
//		Person p2=p1;
		Person p2=(Person) p1.clone();//克隆了一个p1对象,浅克隆
		
		p2.name="x";
		p2.address.aName="长沙";
		
//		System.out.println(p1.address.equals(p2.address));	//true
		
		System.out.println(p1);
		System.out.println(p2);
		 
		 
		
//		A a1=new A();
//		A a2=new A();
//		A a3=a1;
//		System.out.println(a1==a3);					//true
//		System.out.println(a1==a2);					//false
//		System.out.println(a2.equals(a3));			//false
//		System.out.println(a1.equals(a2));			//false
//		System.out.println(a2==a3);					//false
//		System.out.println(a1.equals(a3));			//true
//		
//		System.out.println("-------------------");
//		String str1=new String("abc");
//		String str2=new String("abc");
//		String str3=str1;
//		System.out.println(str1.equals(str3));		//true
//		System.out.println(str1.equals(str2));		//true
//		System.out.println(str1==str3);				//true
//		System.out.println(str2.equals(str3));		//true
//		System.out.println(str2==str3);				//false
//		System.out.println(str1==str2);				//false
		
//		==比较的是栈内存中的值，即堆内存堆内存地址
//		equals比较的是堆内存中的值	string一样，其他对象不一样
	}
}

