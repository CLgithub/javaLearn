package com.cl.javabasis.day13;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

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
//			Process process = runtime.exec("D:/tools/SumatraPDF.exe");
			Process process=runtime.exec("pwd");
			System.out.print(loadStream(process.getInputStream()));
			System.err.print(loadStream(process.getErrorStream()));
			Thread.sleep(1000);
			process.destroy();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String loadStream(InputStream in) throws IOException {
		int ptr = 0;
		in = new BufferedInputStream(in);
		StringBuffer buffer = new StringBuffer();
		while( (ptr = in.read()) != -1 ) {
			buffer.append((char)ptr);
		}
		return buffer.toString();
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
