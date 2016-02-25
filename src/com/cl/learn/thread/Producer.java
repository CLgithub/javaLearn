package com.cl.learn.thread;

public class Producer implements Runnable{
	
	private Q q;
	
	public Producer(Q q) {
		this.q=q;
	}

	@Override
	public void run() {
		int i=0;
		while(true){
			q.producer(i);
			i=(i+1)%2;
		}
	}

}
