package com.cl.learn.thread.test;
/**
 * 设计四个线程，
 * 其中两个线程每次对j加1，另外两个线程每次对j减1
 * @author L
 * @date 2016年2月25日
 */
public class TestControler {
	private static int j=0;
	public static void main(String[] args) {
		Thread1 thread1=new Thread1();
		Thread2 thread2=new Thread2();
		for(int i=0;i<2;i++){
			new Thread(thread1).start();
			new Thread(thread2).start();
		}
	}

	static class Thread1 implements Runnable{
		public void run() {
			inc();
		}
	}
	
	static class Thread2 implements Runnable{
		public void run() {
			dec();
		}
	}
	
	private synchronized static void inc(){
		System.out.println(Thread.currentThread().getName()+":inc");
		j++;
	}
	
	private synchronized static void dec(){
		System.out.println(Thread.currentThread().getName()+":dec");
		j--;
	}
}
