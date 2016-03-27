package com.cl.javabasis.day14;

/**
 * 生产者和消费者线程通信
 * 有一个数据存储空间，划分为两个部分，一部分存储人的姓名，一部分存储性别，
 * 我们开启一个线程，不停地想其中存储姓名和性别（生产者），
 * 开启另一个线程从数据存储空间中取出数据（消费者）
 * 
 * wait():等待，如果线程执行了wait方法，那么线程会进入等待的状态，
 * 		等待状态的线程必须要被其他线程用notify方法才能唤醒
 * notify():唤醒，唤醒等待的线程
 * notifyAll():唤醒线程池中所有等待的线程
 * 
 * wait和notify方法要注意的事项：
 * 	1、wait方法与notify方法是属于object对象的
 * 	2、wait方法与notify方法必须要在同步代码块或同步函数中才能执行
 * 	3、wait方法与notify方法必须由所对象调用
 * 
 * wait():一个线程如果执行了wait()方法，那么该线程就会进入一个以锁对象为标识符的线程池中等待
 * notify():如果一个线程池执行了notify()方法，那么就会唤醒锁对象为标识符的线程中等待线程中其中一个
 */
public class MyDemo4_1 {
	public static void main(String[] args) {
		Studen2 studen=new Studen2();
		Producer2 producer2=new Producer2(studen);
		Customer2 customer2=new Customer2(studen);
		producer2.start();
		customer2.start();
	}
}
class Producer2 extends Thread{
	private Studen2 studen;
	
	public Producer2(Studen2 studen) {
		this.studen = studen;
	}

	public void run() {
		int i=0;
		while(true){
			synchronized (studen) {
				if(!studen.flag){
					if(i%2==0){
						this.studen.setName("小明");
						try {Thread.sleep(10);} catch (InterruptedException e) {}
						this.studen.setGender("男");
					}else {
						this.studen.setName("小红");
						this.studen.setGender("女");
					}
					System.out.println("生产了:"+this.studen);
					studen.flag=true;
					i++;
					studen.notify();//唤醒消费者消费
				}else {
					//已经生产，等待消费
					try {
						studen.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} 
			}
		}
	}
}
class Customer2 extends Thread{
	private Studen2 studen;
	public Customer2(Studen2 studen) {
		this.studen = studen;
	}
	public void run() {
		while(true){
			synchronized (studen) {
				if(studen.flag){
					System.out.println("消费了:"+this.studen);
					studen.flag=false;
					studen.notify();//唤醒生产者生产
				}else {
					//已经消费，等待生产
					try {
						studen.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}
	}
}

class Studen2{
	private String name;
	private String gender;
	boolean flag=false;//是否生产完毕的标识，
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
	@Override
	public String toString() {
		return "[name=" + name + ", gender=" + gender + "]";
	}
	
}

