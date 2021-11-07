package com.cl.javabasis.day14;

/**
 * 一个银行账户有5k，两夫妻一个拿着存折，一个拿着卡，开始取钱比赛，
 * 一次只能取1k，要求不能出现线程安全问题
 * @author L
 * @date 2016年3月22日
 */
public class SynchTest {
	public static void main(String[] args) {
//		Quanqian q1=new Quanqian();
//		q1.setName("小明");
//		Quanqian q2=new Quanqian();
//		q2.setName("小红");
//		q1.start();
//		q2.start();
		
		Q2 q1=new Q2();
		new Thread(q1).start();
		new Thread(q1).start();
	}
}

class Quanqian extends Thread{
	static int qian=5000;
//	static String syn=new String("");
	String syn="";
	int you=0;
	public void run() {
		while(true){
			synchronized (syn) {
				if(qian>0){
//					System.out.println(Thread.currentThread().getName()+"取了一次");
					qian-=100;
					you+=100;
				}else {
					break;
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(Thread.currentThread().getName()+"取了"+you);
	}
}

class Q2 implements Runnable {
	int qian = 5000;
	public void run() {
		while (true) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (this) {
				if (qian > 0) {
					qian-=1000;
					System.out.println(Thread.currentThread().getName()+"取了一次"+"剩"+ qian);
				} else {
					break;
				}
			}
		}
	}
}
