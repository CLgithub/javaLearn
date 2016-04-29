package com.cl.javabasis.day27observer;

import java.util.ArrayList;
import java.util.Random;

public class ListenTest {
	public static void main(String[] args) {
		Sender sender=new Sender();
		A a=new A();
		B b=new B();
		sender.work();
		sender.addList(a);
		sender.addList(b);
	}
}

class Sender{
	String mag;
	String[] mags={"aa","bb","cc"};
	ArrayList<Listener> arrayList=new ArrayList<>();
	
	void addList(Listener listener){
		arrayList.add(listener);
	}
	
	public void work() {
		Random random=new Random();
		new Thread(){
			public void run() {
				while(true){
					int index=random.nextInt(mags.length);
					mag=mags[index];
					System.out.println(mag);
					//发布信息给监听者
					for(Listener listener:arrayList){
						listener.listen(mag);
					}
					try {
						Thread.sleep(random.nextInt(500)+1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}
interface Listener{
	void listen(String mag);
}
class A implements Listener{
	@Override
	public void listen(String mag) {
		if("aa".equals(mag)){
			System.out.println("收到aa");
		}else if("bb".equals(mag)){
			System.out.println("收到bb");
		}else if("cc".equals(mag)){
			System.out.println("收到cc");
		}
	}
}
class B implements Listener{
	@Override
	public void listen(String mag) {
		if("aa".equals(mag)){
			System.out.println("收到aa");
		}else if("bb".equals(mag)){
			System.out.println("收到bb");
		}else if("cc".equals(mag)){
			System.out.println("收到cc");
		}
	}
}