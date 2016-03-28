package com.cl.javabasis.day14;

/**
 * 守护线程（后台线程）:在一个进程中只剩下了守护线程，那么守护线程也会死亡
 * 		
 * 需求：模拟qq下载更新包
 * 
 */
public class MyDemo7 extends Thread{
	public MyDemo7(String name) {
		super(name);
	}
	
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println("更新包目前下次到了"+i+"%");
			if(i==100){
				System.out.println("更新包下载完毕，准备安装……");
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		MyDemo7 d=new MyDemo7("后台线程");
		System.out.println("是守护线程吗？"+d.isDaemon());//判断线程是否是守护线程
		d.setDaemon(true);//设置线程是否为守护线程
		System.out.println("是守护线程吗？"+d.isDaemon());
		d.start();
		for (int i = 1; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}
