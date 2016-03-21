package com.cl.javabasis.day14;

/**
 * 模拟卖票
 * @author L
 * @date 2016年3月22日
 */
public class MyDemo2 {
	public static void main(String[] args) {
//		Thre t1=new Thre();
//		Thre t2=new Thre();
//		Thre t3=new Thre();
//		Thre t4=new Thre();
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
		Thre2 t1=new Thre2();
		new Thread(t1).start();
		new Thread(t1).start();
		new Thread(t1).start();
//		new Thread(t1).start();
	}
}

class Thre extends Thread{
	private static int tickets=100;
	public void run() {
		while(tickets>0){
			shoupiao();
		}
	}
	private void shoupiao() {
		System.out.println(Thread.currentThread().getName()+":"+tickets);
		tickets--;
	}
}

class Thre2 implements Runnable{
	private int tickets=100;
	public void run() {
		while(true){
			if(tickets>0){
				shoupiao();
			}
		}
	}
	private synchronized void shoupiao() {
		System.out.println(Thread.currentThread().getName()+":"+tickets);
		tickets--;
	}
}
