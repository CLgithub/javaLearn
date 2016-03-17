package com.cl.javabasis.day11;

import java.util.Date;
/**
 存在问题：
1.计算的程序的可变的。
2.把会改变的程序抽取出来单独做一个方法。
3.但是该方法不能确定运行的代码，声明为抽象的方法。
4.创建实现类继承并实现父类的未实现的函数。
5.为了避免子类重写父类的模版代码，需要将模版代码修饰为final
 * @author L
 * @date 2016年3月17日
 */
public class MyDemo1 {
	public static void main(String[] args) {
//		testM1();
//		new ClassB().getRunTime();
		new ClassC().getRunTime();
	}
	
	private static void testM1() {
		long startTime=System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			System.out.println("MyDemo1.testM1()");
		}
		long endTime=System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}
}

abstract class ClassA{
	//计算运行时间
	final void getRunTime(){
		long startTime=System.currentTimeMillis();
		cunCode();
		long endTime=System.currentTimeMillis();
		System.out.println("程序运行时间："+(endTime-startTime));
	}
	abstract void cunCode();
}

class ClassB extends ClassA{
	void cunCode() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("ClassB.cunCode()");
		}
	}
}

class ClassC extends ClassA{
	void cunCode() {
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.println("ClassB.cunCode()");
			}
		}
	}
}