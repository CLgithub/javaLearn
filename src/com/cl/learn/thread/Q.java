package com.cl.learn.thread;

public class Q {

	private String name;
	private String gender;
	private Boolean bFull=false;

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

	/**
	 * 生产者方法
	 * @author L
	 * @date 2016年2月25日
	 */
	public synchronized void producer(int i){
		if(bFull){//如果为true，表示已经存入，则该线程进入睡眠等待
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(i==0){
			this.setName("小明");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.setGender("男");
		}else {
			this.setName("小红");
			this.setGender("女");
		}
		bFull=true;//存入后就设为ture
		notify();//唤醒改线程
	}
	
	/**
	 * 消费者方法
	 * @author L
	 * @date 2016年2月25日
	 */
	public synchronized void consumer(Q q){
		if(!bFull){//如果为false，表示已经取走，则该线程睡眠等待
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(q.getName()+"--->"+q.getGender());
		bFull=false;//取走后就设为false
		notify();//唤醒改线程
	}
}
