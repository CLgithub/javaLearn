package com.cl.javabasis.day14;

/**
 * 模拟卖票
 * @author L
 * @date 2016年3月22日
 */
public class MyDemo2 {
	public static void main(String[] args) {
		/*Thre t1=new Thre();
		Thre t2=new Thre();
		Thre t3=new Thre();
		t1.start();
		t2.start();
		t3.start();*/
		
		Thre2 t1=new Thre2(100);
		new Thread(t1,"W1").start();
		new Thread(t1,"W2").start();
		new Thread(t1,"W3").start();
	}
}

class Thre extends Thread{
	static int tickets=50;
	static String syn=new String("");//必须是唯一共享的
	public void run() {
		while(true){
			synchronized(syn){
				shoupiao();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	void shoupiao() {
		if (tickets > 0) {
			System.out.println(Thread.currentThread().getName() + ":" + tickets);
			tickets--;
		}
	}
}

class Thre2 implements Runnable{
	private int tickets;
	
	public Thre2(int tickets) {
		this.tickets = tickets;
	}
	public void run() {
		while(tickets>1){
			shoupiao();
		}
	}
	private synchronized void shoupiao() {//同步方法相当于用this做说对象
		if(tickets>0){
			System.out.println(Thread.currentThread().getName()+":"+tickets);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tickets--;
		}
	}
}
