package com.cl.learn.thread;

public class Consumer implements Runnable{

	private Q q;
	
	public Consumer(Q q) {
		this.q=q;
	}

	@Override
	public void run() {
		while(true){
			synchronized (q) {//新增同步锁，功能满足，但不够好
				System.out.println(q.getName()+"--->"+q.getGender());
			}
		}
	}

}
