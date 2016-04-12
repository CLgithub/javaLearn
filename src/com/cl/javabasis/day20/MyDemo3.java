package com.cl.javabasis.day20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;

/*
 输出字节流：
 ----| OutputStream 是所有输出字节流的父类。抽象类
 --------| FileOutStream 向文件输出数据的输出字节流
 
 FileOutputStream如何使用：
 	1.找到目标文件
 	2.建立数据输出通道
 	3.把数据写出
 	4.关闭资源
 	
 FileOutputStream要注意的细节：
 	1.使用FileOutputStream的时候，如果目标文件不存在，那么就会自动创建目标文件
 	2.使用FileOutputStream写数据的时候，如果目标文件已经存在，那么会先把文件的数据清空，然后再写入数据
 	3.使用FileOutputStream写数据的时候，如果目标文件已经存在，需求在原来的基础上追加数据，需要使用new FileOutputStream(file, true)构造方法，第二个参数为true
 	4.使用FileOutputStream的write()方法写数据的时候，虽然接收的是一个int类型的数据，但是真正写出的只是一个字节的数据，只是
 	把低八位的二进制数据写出，其他二十四位数据全部丢弃
 	
 	00000000-00000000-00000001-11111111	511
 	
 */
public class MyDemo3 {
	public static void main(String[] args) {
		writeTest2();
		readTest();
	}

	//每次只能写一个字节的数据出去
	private static void writeTest1() {
		try {
			//找到目标文件
			File file=new File("E:/aaa/bbb.txt");
			//建立数据输出通道
			FileOutputStream fOutputStream=new FileOutputStream(file);
			//把数据写出
			fOutputStream.write('h');
			fOutputStream.write('a');
			fOutputStream.write('h');
			fOutputStream.write('a');
			//关闭资源
			fOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//使用字节数组
	private static void writeTest2() {
		try {
			//找到目标文件
			File file=new File("E:/aaa/bbb.txt");
			//建立数据输出通道
			FileOutputStream fOutputStream=new FileOutputStream(file, true);
			String data="\r\nhaha abcd";
//			fOutputStream.write(data.getBytes());
			fOutputStream.write(511);
			//关闭资源
			fOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void readTest(){
		try {
			//找到目标文件
			File file=new File("E:/aaa/bbb.txt");
			FileInputStream fileInputStream=new FileInputStream(file);
			int leng=0;
			byte[] buf=new byte[4];
			while((leng=fileInputStream.read(buf))!=-1){
				System.out.println(Arrays.toString(buf));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
