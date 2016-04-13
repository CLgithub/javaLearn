package com.cl.javabasis.day21;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 字节流：字节流读取的是文件中的二进制数据，读取的数据并不会帮你转换成你看得到的字符
 
 字符流：字符流会把读取到的二进制数据进行对应的编码与解码工作，字符流=字节流+编码与解码
 
 输入字符流：
 -----| Reader 输入字符流的基类	抽象类
 ----------| FileReader 读取文件的输入字符流
 
 
 FileReader的用法：
 	1.找到目标文件
 	2.建立数据输出通道
 	3.读取数据
 	4.关闭资源
 
 */
public class MyDemo3 {
	public static void main(String[] args) {
		try {
			readTest1();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readTest1() throws IOException {
		//找到目标文件
//		File file=new File("E:/javaProject/javaLearn/src/com/cl/javabasis/day8/MyDemo1.java");
		File file=new File("E:/学习视频/2015传智基础33/day21/说明.txt");
		//建立数据输出通道
		FileReader fileReader=new FileReader(file);
//		int centent=fileReader.read();
//		System.out.print((char)centent);
		
		//使用缓存字符数组读取文件
		int leng=0;
		char[] buf=new char[1024];
		while((leng=fileReader.read(buf))!=-1){
			System.out.println(new String(buf,0,leng));
		}
		
		fileReader.close();
	}
}
