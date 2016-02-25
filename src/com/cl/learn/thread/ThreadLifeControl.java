package com.cl.learn.thread;

public class ThreadLifeControl {
	public static void main(String[] args) {
		ThreadLife threadLife=new ThreadLife();
		new Thread(threadLife).start();
		for(int i=0;i<60;i++){
			if(i==50){
				threadLife.stopMe();
			}
			System.out.println("ThreadLifeControl.main()"+i);
		}
		
	}
}
