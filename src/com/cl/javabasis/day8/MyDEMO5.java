package com.cl.javabasis.day8;

/*
多态练习
	1：多态可以作为形参，接受范围更广的对象，避免函数重载过度使用。
		1：定义功能，根据输出任何图形的面积和周长。
		子类重写了父类的抽象方法，多态下，会执行子类的非静态方法。
	2：多态可以作为返回值类型。
		获取任意一辆车对象
	3：抽象类和接口都可以作为多态中的父类引用类型。
*/
public class MyDEMO5 {
	public static void main(String[] args) {
//		getAreaAndLen(new Rect(3.1,4));
		getAreaAndLen(new Circle1(1));
	}
	//定义一个方法，传一个图形进去，得到其面积和周长
	private static void getAreaAndLen(MyShape myShape){
		System.out.println(myShape.getArea());
		System.out.println(myShape.getLen());
	}
}
//抽象图形
abstract class MyShape{
	//抽象得到面积
	public abstract double getArea();
	//抽象得到周长
	public abstract double getLen();
}
//矩形
class Rect extends MyShape{
	public Rect(double width,double height) {
		this.width=width;
		this.height=height;
	}
	double width ;
	double height;
	public double getArea() {
		return width*height;
	}

	public double getLen() {
		return 2*(width+height);
	}
}
//圆形
class Circle1 extends MyShape {
	Circle1(double r) {
		this.r=r;
	}
	double r;// 半径
	public static final double PI = 3.14;
	public double getLen() {
		return 2 * PI * r;
	}
	public double getArea() {
		return PI * r * r;
	}
}