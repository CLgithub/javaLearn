package com.cl.javabasis.day14;

import java.sql.Struct;

/**
 * 生产者和消费者线程通信
 * 有一个数据存储空间，划分为两个部分，一部分存储人的姓名，一部分存储性别，
 * 我们开启一个线程，不停地想其中存储姓名和性别（生产者），
 * 开启另一个线程从数据存储空间中取出数据（消费者）
 * 
 * wait():等待，如果线程执行了wait方法，那么线程会进入等待的状态，
 * 		等待状态的线程必须要被其他线程用notify方法才能唤醒
 * notify():唤醒，唤醒等待的线程
 * 
 * wait和notify方法要注意的事项：
 * 	1、wait方法与notify方法是属于object对象的
 * 	2、wait方法与notify方法必须要在同步代码块或同步函数中才能执行
 * 	3、wait方法与notify方法必须由所对象调用
 */
public class MyDemo4 {
	public static void main(String[] args) {
		Studen studen1 = new Studen();
		Thread pThread=new Thread(new Producer(studen1));
		Thread cThread=new Thread(new Consumer(studen1));
		pThread.start();
		cThread.start();
	}
}

class Producer implements Runnable{
	Studen studen;
	public Producer(Studen studen) {
		this.studen = studen;
	}
	public void run() {
		int i=0;
		while(true){
			studen.producer(i);
			i++;
		}
	}
}

class Consumer implements Runnable{
	Studen studen;
	public Consumer(Studen studen) {
		this.studen = studen;
	}
	public void run() {
		while(true){
			studen.cons();
		}
	}
}

class Studen{
	boolean flag = false;//true:已写,false:已读
	private String name;
	private String gender;
	
	synchronized void producer(int i) {
//		System.out.println("Studen.producer()");
		if(flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}/*else {*/ //无论何时醒来，都要存入一个新的，避免重复
			if(i%2==0){
				this.setName("小明");
				this.setGender("男");
				System.out.println("生产了"+this);
			}else {
				this.setName("小红");
				this.setGender("女");
				System.out.println("生产了"+this);
			}
			flag=true;
			this.notify();
		/*}*/
		
	}
	

	synchronized void cons() {
//		System.out.println("Studen.cons()");
		if(!flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("消费了"+this);
//			this.setName(null);
//			this.setGender(null);
			flag=false;
			this.notify();
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String toString() {
		return "Studen [name=" + name + ", gender=" + gender + "]";
	}
}