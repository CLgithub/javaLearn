package com.cl.javabasis.day14;

import java.util.jar.Attributes.Name;

/**
 * 线程的停止：
 * 		1.停止一个线程我们一般都会通过一个变量去停止
 * 		2.如果需要停止一个处于等待状态下的线程，我们需要变量配合notify方法或者interrupt唤醒来使用
 */
public class MyDemo6 {
	public static void main(String[] args) {
		
		Thread2 t=new Thread2("小明");
		
		t.setPriority(10);
		t.start();
		for (int i = 0; i < 150; i++) {
			System.out.println(Thread.currentThread().getName()+i);
//			thread2.stop();
//			thread2.interrupt();//interrupt()无法停止一个线程
			if(i==80){
				t.flag=false;
				t.interrupt();//把线程的等待状态强制清除，被清除状态的线程会接受到一个InterruptedException异常
				/*synchronized (t) {
					t.notify();
				}*/
			}
		}
	}
}

class Thread2 extends Thread{
	boolean flag=true;
	
	public Thread2(String name) {
		super(name);
	}
	
	public void run() {
		int i=0;
		while(flag){
			synchronized (this) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					System.out.println("接受到异常");
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+i);
				i++;
			}
		}
	}
	
}
