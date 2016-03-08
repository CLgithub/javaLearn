package com.cl.javabasis.day5;

public class MyCar {
	//构造代码块，
	{System.out.println("构造代码块");}
	
	private int num;
	
	public MyCar(){
		
	}
	
	public MyCar(int x) {
		this.num=x;
	}
	
	public void run(){
		System.out.println(num+"轮子的汽车跑起来啦");
	}
}

class Test2{
	public static void main(String[] args) {
		MyCar car1=new MyCar();
		car1.run();
	}
	
}
