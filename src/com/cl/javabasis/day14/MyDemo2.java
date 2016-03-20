package com.cl.javabasis.day14;

import java.io.IOException;

import org.omg.SendingContext.RunTime;

/**
 * RunTime	该类主要代表了应用程序的运行环境
 * 		单例
 * 		getRuntime() 返回当前程序运行环境
 * 		exec(command);//根据指定的路径执行指定的可执行文件
 *		freeMemory()//返回java虚拟机中空闲内存量(字节)
 *		maxMemory()//返回java虚拟机试图管理的最大内存
 * 
 */
public class MyDemo2 {
	public static void main(String[] args) {
//		method1();
		method2();
	}
	
	static void method1() {
		try {
			Runtime runtime = Runtime.getRuntime();
			// 根据指定的路径执行指定的可执行文件,如果是osx呢，没有可执行文件
			Process process = runtime.exec("D:/tools/SumatraPDF.exe");
			Thread.sleep(1000);
			process.destroy();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void method2(){
		Runtime runtime = Runtime.getRuntime();
		//返回java虚拟机中空闲内存量(字节)
		long l=runtime.freeMemory();
		//返回java虚拟机试图管理的最大内存
		long l2=runtime.maxMemory();
		//返回java虚拟机的内存总量
		long l3=runtime.totalMemory();
		System.out.println(l);
		System.out.println(l2);
		System.out.println(l3);
	}
}
