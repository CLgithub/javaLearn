package com.cl.javabasis.day10;

public class MyDemo3 {
	public static void main(String[] args) {
		Dome1.Inner1 inner1=new Dome1().new Inner1();
		inner1.show();
		new MyDemo3().myshow();
	}
	
	int a=1;
	
	private void myshow(){
		MyDemo3.this.a=3;
		System.out.println(MyDemo3.this.a);
	}
}
class Dome1{
	int num=10;
	class Inner1{
		int num=20;
		void show(){
			System.out.println("外show num="+Dome1.this.num);
			System.out.println("内show num="+Inner1.this.num);
		}
	}
}