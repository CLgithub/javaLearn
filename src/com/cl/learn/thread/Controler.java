package com.cl.learn.thread;

public class Controler {
	public static void main(String[] args) {
		Q q=new Q();
		new Thread(new Producer(q)).start();
		new Thread(new Consumer(q)).start();
	}
}
