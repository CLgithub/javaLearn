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
			if(i==0){
				q.setName("小明");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				q.setGender("男");
			}else {
				q.setName("小红");
				q.setGender("女");
			}
			i=(i+1)%2;
		}
	}

}
