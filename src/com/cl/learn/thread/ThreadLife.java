package com.cl.learn.thread;

public class ThreadLife implements Runnable{
	
	private Boolean bfull=true;

	public void stopMe(){
		bfull=false;
	}
	
	@Override
	public void run() {
		//线程生命周期控制演示，控制线程生命，推荐使用控制run方法中的循环条件方式来结束线程
		while(bfull){
			System.out.println(Thread.currentThread().getName());
		}
	}

}
