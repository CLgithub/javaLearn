package com.cl.learn.javaobject;

public class SingletonTest {
	int age=0;
	//单例设计一
	private SingletonTest() {
	}
	private static final SingletonTest singletonTest = new SingletonTest();
	public static SingletonTest getSingletonTest() {
		return singletonTest;
	}
	//单例设计二
//	private static SingletonTest singletonTest=null;
//	public static synchronized SingletonTest geta(){
//		if(singletonTest==null){
//			singletonTest=new SingletonTest();
//		}
//		return singletonTest;
//	}
}
