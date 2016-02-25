package com.cl.learn.thread;

public class Q {

	private String name;
	private String gender;

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
	}
	
	/**
	 * 消费者方法
	 * @author L
	 * @date 2016年2月25日
	 */
	public synchronized void consumer(Q q){
		System.out.println(q.getName()+"--->"+q.getGender());
	}
}
