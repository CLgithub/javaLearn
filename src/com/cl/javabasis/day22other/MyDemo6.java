package com.cl.javabasis.day22other;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/*
 打印流（prinStream）1.打印流可以打印任意类型的数据，而且打印数据之前都会先把数据转换成字符串再进行打印
 				2.收集异常到日志信息
 
 */
public class MyDemo6 {
	public static void main(String[] args) throws IOException {
//		FileOutputStream fileOutputStream=new FileOutputStream("/Users/L/Downloads/aaa/prin");
//		fileOutputStream.write("97".getBytes());
//		fileOutputStream.close();
		
//		File file=new File("/Users/L/Downloads/aaa/prin");
//		PrintStream printStream=new PrintStream(file);
//		printStream.println(97);
//		printStream.println(3.14);
//		printStream.println('a');
//		printStream.println(true);
//		printStream.println(new Animal("cat", "黑色"));
		
		//out其实是System的一个PrintStream对象，默认是输出到控制台
//		System.setOut(printStream);//重新设置了标准的输出流
//		System.out.println("标准输出流输出到文件");
		
		
		//收集异常到日志信息
		File file2=new File("/Users/L/Downloads/aaa/20160420.log");
		PrintStream logPrintStream=new PrintStream(new FileOutputStream(file2,true));
		try {
//			int c=4/0;
//			System.out.println(c);
			int[] arr=null;
			System.out.println(arr.length);
		} catch (Exception e) {
			e.printStackTrace(logPrintStream);
		}
		
	}
}
class Animal{
	String name;
	String color;

	public Animal(String name, String color) {
		this.name = name;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", color=" + color + "]";
	}
	
	
}
