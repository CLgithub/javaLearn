package com.cl.javabasis.day14;

/**
 * 进程：正在运行的程序，负责了这个程序的内存空间分配，代表了内存中的执行区域。
 * 线程：就是在一个进程中负责一个执行路径。
 * 多线程：就是在一个进程中多个执行路径同时执行。
 * 		创建线程两种方式：
 * 			一继承thread类
 * 			二实现runnable接口
 */
public class MyDemo1 {
	public static void main(String[] args) {
		new Thread1("小明").start();
		new Thread1("小红").start();
		for (int i = 0; i < 100; i++) {
			System.out.println("MyDemo1.main()");
		}
	}
}

class Thread1 extends Thread{
	private String name;
	public Thread1(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(this.name+i);
		}
	}
	
	
}