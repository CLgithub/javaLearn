package com.cl.javabasis.day22other;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
 转换流：
 
 输入字节流的转换流：InputStreamReader 字节流通向字符流的桥梁，其实就是把字节数组解码成字符 输入字节流---->输入字符流
 	InputStreamReader
 	
 输出字节流的转换流：OutputStreamWriter	字符通向字节的桥梁 	输出字节流－－－>输出字符流
 	OutputStreamWriter
 	
 转换流的作用：
 	1.如果目前所获取到的是字节流需要转换成字符流使用，这时候就可以用到转换流。字节流---->字符流
 	2.使用转换流可以指定编码表进行读写文件
 	
 */
public class MyDemo8 {
	public static void main(String[] args) throws IOException {
//		readTest();
//		writerTest();
		writerTest2();
		readTest2();
	}
	
	//使用输入字节流的转换流指定编码表进行读取文件数据
	public static void readTest2() throws IOException {
		File file=new File("/Users/L/Downloads/aaa/demo8_2");
		FileInputStream fileInputStream=new FileInputStream(file);
		//创建字节流的转换流并且指定编码表
		InputStreamReader isr=new InputStreamReader(fileInputStream,"gbk");
		//读取
		int length=0;
		char[] buf=new char[1024];
		while((length=isr.read(buf))!=-1){
			System.out.println(new String(buf,0,length));
		}
	}
	
	//使用输出字节流的转换流指定码表写出数据
	public static void writerTest2() throws IOException {
		File file=new File("/Users/L/Downloads/aaa/demo8_2");
		//建立数据输出通道
		FileOutputStream fileOutputStream=new FileOutputStream(file,true);
		//把输出字节流转换成字符流并指定编码表
		OutputStreamWriter osw=new OutputStreamWriter(fileOutputStream,"gbk");
		osw.write("大家好啊");
		//关闭资源
		osw.close();
	}
	
	//输出字节流－－》字符流
	public static void writerTest() throws IOException {
		File file=new File("/Users/L/Downloads/aaa/demo8");
		FileOutputStream fileOutputStream=new FileOutputStream(file);
//		fileOutputStream.write("大家好".getBytes());
		//目标：需要把输出字流转换成输出字符流
		
		OutputStreamWriter osw=new OutputStreamWriter(fileOutputStream);
		
		osw.write("大家好");
		osw.flush();
		osw.close();
		
	}
	
	//输入字节流－－－》字符流
	public static void readTest() throws IOException {
		InputStream in=System.in;//获取了标准输入流
//		System.out.println("读到到字符："+(char)in.read());//一次只能读取一个字节
		
		//目标：需要把字节流转换成字符流	转换流
		
		BufferedReader bReader=new BufferedReader(new InputStreamReader(in));
		//读取
		String line="";
		while((line=bReader.readLine())!=null){
			System.out.println("读到的内容是："+line);
		}
	}
}
