package com.cl.javabasis.day27reflect;

/*
 反射：当一个字节码文件加载到内存的时候，jvm会对该字节码进行解剖，然后会创建一个对象的Class对象，把字节码文件的信息全部都存储到该Class对象中，
 我们只要获取到该Class对象，我们就可以使用字节码对象设置对象的属性或调用对象的方法等操作
 
 注意⚠：在反射技术中，一个类的任何成员都有对应的类进行描述。比如：成员变量（Field），方法（Method）
 
 */
public class MyDemo1 {
	Person p;
	public static void main(String[] args) throws ClassNotFoundException {
		Person p=new Person(110, "小明");
		
		//获取Class对象的方式一：用过类的全名获取		推荐使用
		Class clazz1=Class.forName("com.cl.javabasis.day27reflect.Person");
		System.out.println("clazz1:"+clazz1);
		//获取Class对象的方式二:通过类名获取
		Class clazz2=Person.class;
		System.out.println("clazz1==class2? "+(clazz1==clazz2));
		//获取Class对象的方式二:通过对象获取
//		Class clazz3=new Person().getClass();
//		System.out.println("clazz2==clazz3? "+(clazz2==clazz3));
		
	}
}

