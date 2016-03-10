package com.cl.javabasis.day10;

public class MyDemo4 {
	public static void main(String[] args) {
		Demo2 demo2=new Demo2();
		demo2.method1(5);
	}
}
class Demo2{
	int num=1;
	public void method1(final int y){
		final int x=2;
		class Inner{
			void show(){
				System.out.println("num="+Demo2.this.num);
				System.out.println("x="+x);
				System.out.println("y="+y);
			}
		}
		new Inner().show();
	}
}
