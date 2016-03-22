package com.cl.javabasis.day14;

/**
 * 进程：正在运行的程序，负责了这个程序的内存空间分配，代表了内存中的执行区域。
 * 线程：就是在一个进程中负责一个执行路径。
 * 多线程：就是在一个进程中多个执行路径同时执行。
 * 		创建线程两种方式：
 * 			一继承thread类
 * 			二实现runnable接口
 * 
 * 		线程常用方法
 			Thread(String name)     初始化线程的名字
			setName(String name)    设置线程对象名
			getName()            	返回线程的名字
			
			sleep()					线程睡眠指定的毫秒数。 静态的方法， 那个线程执行了sleep方法代码那么就是那个线程睡眠。
			currentThread()      	返回当前的线程对象，该方法是一个静态的方法， 注意： 那个线程执行了currentThread()代码就返回那个线程 的对象。
			getPriority()             返回当前线程对象的优先级   默认线程的优先级是5
			setPriority(int newPriority) 设置线程的优先级    虽然设置了线程的优先级，但是具体的实现取决于底层的操作系统的实现（最大的优先级是10 ，最小的1 ， 默认是5）。
 * 		
 */
public class MyDemo1 {
	public static void main(String[] args) {
		Thread1 thread1=new Thread1("小明");
		Thread1 thread2=new Thread1("小红");
		thread1.setPriority(10);
		thread2.setPriority(1);
		System.out.println(thread1.getPriority());
		System.out.println(thread2.getPriority());
		
		thread1.start();
//		thread2.setName("小白");//设置线程名
		thread2.start();
		/*for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread());//得到线程对象
			System.out.println(Thread.currentThread().getPriority());//得到线程优先级
		}*/
	}
}

class Thread1 extends Thread{
	public Thread1(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
	
}