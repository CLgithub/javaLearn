package com.cl.javabasis.day14;

/**
 * 线程死锁问题测试
 * @author L
 * @date 2016年3月22日
 */
public class MyDemo3 {
	public static void main(String[] args) {
		new T1();
	}
}

class T1 implements Runnable{
	A a=new A();
	B b=new B();
	public T1() {
		Thread.currentThread().setName("主线程");
		new Thread(this).start();
		a.foo(b);
		System.out.println("回到主线程");
	}
	public void run() {
		Thread.currentThread().setName("T1线程");
		b.bar(a);
		System.out.println("回到T1线程");
	}
}

class A {
	synchronized void foo(B b){
		String name=Thread.currentThread().getName();
		System.out.println(name+"执行A.foo()");
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println(name+"尝试调用b的last()方法");
		b.last();
	}
	synchronized void last(){
		System.out.println("A.last()");
	}
}

class B {
	synchronized void bar(A a){
		String name=Thread.currentThread().getName();
		System.out.println(name+"执行B.bar()");
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println(name+"尝试调用a的last()方法");
		a.last();
	}
	synchronized void last() {
		System.out.println("B.last()");
	}
}