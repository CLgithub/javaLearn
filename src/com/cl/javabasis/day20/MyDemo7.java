package com.cl.javabasis.day20;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 输出字节流
 -----| OutputStream 所有输出字节流的基类	  抽象
 ----------| FileOutputStream 向文件输出数据的输出字节流
 ----------| BufferedOutputStream 缓存输出字节流		内部也是维护了一个8kb的自己数组而已
 
 使用BufferedOutputStream的步骤：
 	1.找到目标文件
 	2.建立数据输出通道
 	3.建立缓存输出字节流
 	4.把缓存数组中的数据写到硬盘上
 
 BufferedOutputStream要注意的细节
 	1.使用BufferedOutputStream写数据的时候，它的write方法是先把数据写到他内部维护的字节数组中
 	2.使用BufferedOutputStream写数据的时候，它的write方法是先把数据写到他内部维护的字节数组中，如果需要把数据真正的写到硬盘上，
 	需要调用flush或close方法，或者是内部维护的自己数组已经填满数据的时候
 
 
 */
public class MyDemo7 {
	public static void main(String[] args) {
		try {
			test1();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void test1() throws IOException {
		//找到文件
		File file=new File("E:/aaa/aaa.txt");
		//建立数据输出通道
		FileOutputStream fileOutputStream=new FileOutputStream(file);
		//建立缓存输出字节流
		BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
		//把数据写出
		bufferedOutputStream.write("bbb".getBytes());
		//把缓存数组中的数据写到硬盘上
//		bufferedOutputStream.flush();
		//关闭资源
		bufferedOutputStream.close();
	}
}
