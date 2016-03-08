package com.cl.javabasis.day5;

public class MyDemo2 {
	public static void main(String[] args) {
		MyCar c1=new MyCar();
		MyCar c2=c1;
//		c1.color="red";
//		c1.num=5;
//		c2.num=3;
//		Car.Car(3);
		c1.run();
	}
}

class Car{
	String color;
	int num;
	void run(){
		System.out.println(num+"轮子的汽车跑起来啦");
	}
	public int Car() {
		this.num=2;
		return 0;
	}
	Car() {
		this.num=3;
	}
}
