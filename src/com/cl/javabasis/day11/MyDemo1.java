package com.cl.javabasis.day11;

import java.time.Month;
import java.util.Arrays;
import java.util.Date;
/**
 存在问题：
1.计算的程序的可变的。
2.把会改变的程序抽取出来单独做一个方法。
3.但是该方法不能确定运行的代码，声明为抽象的方法。
4.创建实现类继承并实现父类的未实现的函数。
5.为了避免子类重写父类的模版代码，需要将模版代码修饰为final

模板模式的步骤
	1.先写出解决该类事情其中的一件解决方案
	2.分析代码，把会发生变化的代码抽取出来独立成一个方法，把该方法描述成一个抽象的方法
	
	
	
 * @author L
 * @date 2016年3月17日
 */
public class MyDemo1 {
	public static void main(String[] args) {
//		testM1();
		new ClassD().getRunTime();
		new ClassE().getRunTime();
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

class ClassD extends ClassA{
	@Override
	void cunCode() {
		int[] arr = new int[10000];
		for(int i=0;i<100;i++){
//			System.out.println((int)(Math.random()*100));
			arr[10000-1-i]=(int)(Math.random()*100);
		}
		Arrays.sort(arr);
	}
}
class ClassE extends ClassA{
	@Override
	void cunCode() {
		int[] arr = new int[10000];
		for(int i=0;i<100;i++){
//			System.out.println((int)(Math.random()*100));
			arr[10000-1-i]=(int)(Math.random()*100);
		}
		for (int j = 0; j < arr.length - 1; j++) {
			for (int i = 0; i < arr.length -1 - j; i++) {
				if (arr[i] > arr[i + 1]) {
					arr[i] = arr[i] ^ arr[i + 1];
					arr[i + 1] = arr[i] ^ arr[i + 1];
					arr[i] = arr[i] ^ arr[i + 1];
				}
			}
		}
	}
}