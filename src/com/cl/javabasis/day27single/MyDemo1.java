package com.cl.javabasis.day27single;

/*
 单列设计模式：
 	饿汉单列设计模式
 	
 	懒汉单列设计模式（存在线程安全问题）
 		步骤：
 			1.私有化构造方法
 			2.声明本类的引用类型对象，但是不要创建对象
 			3. 声明一个公共静态的方法获取本类的对象，获取之前先判断是否已经创建了本类的对象了，如果已经创建了
 			就不要在创建直接返回即可，如果还没有创建，那么就先创建本类的引用类型变量，然后再返回。
 */
public class MyDemo1 {

}

//饿汉式
class Demo1{
	private Demo1(){}
	
	private final static Demo1 c1=new Demo1();
	
	public static Demo1 getc1(){
		return c1;
	}
}

//懒汉式
class Demo2 {
	private Demo2() {};

	public static Demo2 getDemo2() {
		if(demo2==null){			//解决效率问题
			synchronized("锁"){		//解决线程安全问题
				if (demo2 == null) {
					demo2 = new Demo2();
				}
			}

		}
		return demo2;
	}

	private static Demo2 demo2 = null;
}
