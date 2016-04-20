package com.cl.javabasis.day14;

/*
 生产者与消费者练习
 */
public class MyDemo4Test1 {
	public static void main(String[] args) {
		Product1 product1=new Product1();
		Producer1 producer1=new Producer1(product1);
		Consumer1 consumer1=new Consumer1(product1);
		new Thread(producer1).start();
		new Thread(consumer1).start();
	}
}

/**
 * 生产者
 * @date 2016年4月20日
 */
class Producer1 implements Runnable{
	Product1 product1;
	public Producer1(Product1 product1) {
		this.product1 = product1;
	}
	@Override
	public void run() {
		int i=0;
		while(true){
			synchronized (product1) {
				if(product1.flag){
					try {
						product1.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else {
					product(i);
					i++;
					product1.flag=true;
					product1.notify();
				}
			}
		}
	}
	private void product(int i) {
		if(0==i%2){
			product1.setName("小明");
			product1.setGender("男");
		}else {
			product1.setName("小红");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			product1.setGender("女");
		}
		System.out.println("生产了："+product1);
	}
}
/**
 * 消费者
 * @date 2016年4月20日
 */
class Consumer1 implements Runnable{
	Product1 product1;
	public Consumer1(Product1 product1) {
		this.product1 = product1;
	}
	@Override
	public void run() {
		while(true){
			consumer();
		}
	}
	private void consumer() {
		synchronized (product1) {
			if(product1.flag){
				System.out.println("消费了："+product1);
				product1.flag=false;
				product1.notify();
			}else {
				try {
					product1.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
}
class Product1{
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
		return "Product1 [name=" + name + ", gender=" + gender + "]";
	}
	
}
