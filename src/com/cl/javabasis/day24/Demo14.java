package com.cl.javabasis.day24;

/*
 线程：
 多线程存在的意义：解决了一个进程允许多个任务可以同时执行
 
 多线程的创建方式：
 	方式一：继承Thread类
 		1.自定义一个类继承Thread。
 		2.重写Thread的run方法，把自定义线程的任务代码放在run方法里
 		3.创建Thread类的子类对象，并调用start方法开启线程
 	
 	方法二：实现Runnable接口
 		1.自定义一个类实现Runnable接口
 		2.实现Runnable的run方法
 		3.创建Runnable实现类的对象
 		4.创建Thread对象，把Runnable实现类的对象作为参数传递
 		5.调Thread的对象的start方法开启线程
 
 出现线程安全问题的根本原因：
	1. 存在两个或者两个以上的线程共享着资源。
	2. 操作资源的代码块必须有语句。
 
 java中的同步机制：
 	1.同步代码块
 		格式：
 			synchronized(锁对象){
 			}
 		同步代码块要主要的细节：
 			1.锁对象可以是任意的对象
 			2.锁对象必须是多线程共享的资源，否则锁不住
 			3.没有线程安全问题的时候不要使用锁，因为会导致效率降低
 			4.调用sleep方法并不会释放锁对象，但是调用wait方法的线程就会释放锁对象。
 	2.同步函数
 		格式：
	 		修饰符 synchronized 返回值类型 函数名(形参列表..){
			}
		主意⚠：
			1. 同步函数的锁对象是不能任意的，非静态同步函数的锁对象是this对象，静态函数的锁对象是当前字节码对象。
			2. 同步函数的锁不能由你指定，是固定的。
 锁🔒：
 
 */
public class Demo14  {
	public static void main(String[] args) {
		Thread1 thread1=new Thread1();
		thread1.start();//开启里自定义的线程。线程一旦开启就会执行run方法中的代码块
		
		Thread2 thread2=new Thread2();
		new Thread(thread2).start();
	}
}

class Thread1 extends Thread{
	
	@Override
	public void run() {
		//把自定义线程的任务代码放在run方法里
		
	}
}
class Thread2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
