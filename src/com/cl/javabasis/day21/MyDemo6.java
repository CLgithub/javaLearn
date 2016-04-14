package com.cl.javabasis.day21;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/*
 输入字符流：
 -----| Reader 所有输入字符流的基类	抽象类
 ----------| FileReader 读取文件字符的输入字符流
 ----------| BufferedReader 缓存输入字符流	缓存输入字符流出现的目的是为了提高读取文件字符的效率和拓展了FileReader的功能。其实该类内部也是维护了一个字符数组（8k字符）
 
 BufferedReader的使用步骤：
 	1.找到目标文件
 	2.建立数据的输入通道
 	3.建立缓存输入字符流
 	4.读取数据
 
 */
public class MyDemo6 {
	public static void main(String[] args) throws IOException {
		readTest1();
	}
	
	//自己实现readLine方法
	public static String myReadLine(FileReader fileReader) throws IOException {
		//创建字符串缓存类对象
		StringBuilder sBuilder=new StringBuilder();//用来保存每次读到的数据
		
		int content=0;
		while((content=fileReader.read())!=-1){
			if(content=='\r'){//	13
				continue;
			}else if(content=='\n'){//	10
				break;
			}else {
				sBuilder.append((char)content);
			}
		}
		//如果已经读取完毕并且最后一句要已经返回
		if((content==-1)&&(sBuilder.toString().equals(""))){
			return null;
		}
		return sBuilder.toString();
		
	}
	
	
	public static void readTest1() throws IOException {
		//找到目标文件
		File file=new File("E:/aaa/ccc.txt");
//		File file=new File("E:/aaa/aaa.txt");
		//建立数据输入通道
		FileReader fileReader=new FileReader(file);
		//建立缓存输入字符流
		BufferedReader bufferedReader=new BufferedReader(fileReader);
		
//		//读取数据
//		int content=bufferedReader.read();	//都到了一个字符。该字符读取到的字符从内部字符数组中获取
//		System.out.println((char)content);
		
		//使用BufferedReader拓展的功能readLine()，一次读取一行文本，如果读到文件末尾返回null标识
//		String line="";
//		while((line=bufferedReader.readLine())!=null){
//			System.out.println(line);
////			System.out.println(Arrays.toString(line.getBytes()));//虽然readLine方法每次读取一行字符，但是返回的数据是不包含\r\n的
//		}
		
		String line="";
		while((line=myReadLine(fileReader))!=null){
			System.out.println(line);
		}
		
		//关闭资源
		bufferedReader.close();
	}
}
