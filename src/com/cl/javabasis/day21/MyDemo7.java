package com.cl.javabasis.day21;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 输入字符流：
 -----| Reader 所有输入字符流的基类	抽象类
 ----------| FileReader 读取文件字符的输入字符流
 ----------| BufferedReader 缓存输入字符流	缓存输入字符流出现的目的是为了提高读取文件字符的效率和拓展了FileReader的功能。其实该类内部也是维护了一个字符数组（8k字符）
 
 输出字符流：
 -----| Writer 所有输出字符流的基类	抽象类
 ----------| FileWriter 向文件输出字符数据的输出字符流
 ----------| BufferedWriter 缓存输出字符流	缓存输出字符流作用：提高FileWriter的写字符数据的效率与拓展FileWriter的功能。
 BufferedWriter内部只不过是提供了一个8192长度的字符数组作为缓冲区而已，拓展了FileWriter的功能。
 
 BufferedWriter如何使用：
 	1.找到目标文件
 	
 
 */
public class MyDemo7 {
	public static void main(String[] args) throws IOException {
		writerTest1();
	}
	
	public static void writerTest1() throws IOException {
		//找到目标文件
		File file=new File("E:/aaa/ccc.txt");
		//建立数据输出通道
		FileWriter fileWriter=new FileWriter(file,true);
		//建立缓存输出流对象
		BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);//
		//拓展功能
		bufferedWriter.newLine();//其实是换行而已。实际上就是是向文件输出\r\n而已
		//写出数据
		bufferedWriter.write("范德萨范德萨");
		
		
		
//		bufferedWriter.flush();
		//关闭资源
		bufferedWriter.close();
	}
}
