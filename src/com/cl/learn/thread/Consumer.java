package com.cl.learn.thread;

public class Consumer implements Runnable{

	private Q q;
	
	public Consumer(Q q) {
		this.q=q;
	}

	@Override
	public void run() {
		while(true){
			q.consumer(q);
		}
	}

}
