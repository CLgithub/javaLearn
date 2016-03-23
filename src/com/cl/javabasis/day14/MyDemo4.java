package com.cl.javabasis.day14;

import java.sql.Struct;

/**
 * 生产者和消费者线程通信
 * 有一个数据存储空间，划分为两个部分，一部分存储人的姓名，一部分存储性别，
 * 我们开启一个线程，不停地想其中存储姓名和性别（生产者），
 * 开启另一个线程从数据存储空间中取出数据（消费者）
 * @author 陈雷
 * @date 2016年3月23日
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
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}/*else {*/ //无聊何时醒来，都要存入一个新的，避免重复
			if(i%2==0){
				System.out.println(this+"---->小明,男");
				this.setName("小明");
				this.setGender("男");
			}else {
				System.out.println(this+"---->小红,女");
				this.setName("小红");
				this.setGender("女");
			}
			flag=true;
			notify();
		/*}*/
		
	}
	

	synchronized void cons() {
//		System.out.println("Studen.cons()");
		if(!flag){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println(this);
//			this.setName(null);
//			this.setGender(null);
			flag=false;
			notify();
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