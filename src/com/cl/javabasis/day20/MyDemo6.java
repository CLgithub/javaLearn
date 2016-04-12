package com.cl.javabasis.day20;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/*
  我们清楚读取文件数据使用缓存数组读取效率更高，sun也知道，那么就给我们提供了一个
  ----缓存输入字节流，让我们可以更高效率读取文件
  
  输入字节流:
 -----| InputStream 输入自己流的基类。抽象
 ----------| FileInputStream 读取文件数据输入字节流
 ----------| BufferedInputStream 缓存输入字节流	缓存输入字节流的出现主要是为了提高读取文件数据的效率。其实
 该类内部只不过是维护了一个8kb的字节数组而已。
 
 注意：凡是缓存流都不具备读写数据的能力。
 
 使用BufferedInputStream的步骤：
 	1.找到目标文件
 	2.建立数据输入通道
 	3.建立缓存输入字节流
 	
 
 */
public class MyDemo6 {
	public static void main(String[] args) {
		try {
			readTest2();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//读取文件的时候我们都是使用缓存数组。效率更高
	public static void  readTest() throws IOException {
		File file=new File("E:/aaa/aaa.txt");
		FileInputStream fileInputStream=new FileInputStream(file);
		byte[] buf=new byte[1024];
		int leng=0;
		while((leng=fileInputStream.read(buf))!=-1){
			System.out.println(new String(buf,0,leng));
		}
		fileInputStream.close();
	}
	
	public static void  readTest2() throws IOException {
		//1.找到目标文件
		File file=new File("E:/aaa/aaa.txt");
		//2.建立数据输入通道
		FileInputStream fileInputStream=new FileInputStream(file);
		//3.建立缓存输入字节流
		//疑问一：为什么创建BufferedInputStream的时候要传递FileInputStream？
			//BufferedInputStream本身是不具备读写文件的能力，所有需要借助fileInputStream
		BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
		//读取文件数据
		int content=0;
		//疑问二：BufferedInputStream出现的目的是为了提高读取文件的效率。但是这个BufferedInputStream的read方法每次只读取一个字节的数据
		//而FileInputStream每次也是读取一个字节的数据，那么BufferedInputStream效率高从何而来
		
		while((content=bufferedInputStream.read())!=-1){
			System.out.println((char) content);
		}
		bufferedInputStream.close();//不与文件交互，他的close方法其实关闭的是fileInputStream.close();（看源码）
//		fileInputStream.close();
	}
}
