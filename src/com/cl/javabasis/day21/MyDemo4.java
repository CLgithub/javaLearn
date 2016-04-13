package com.cl.javabasis.day21;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 输出字符流：
 
 -----| Writer 输出字符流的基类	抽象
 ----------| FileWriter 向文件输出数据的输出字符流
 
 FileWriter的使用步骤：
 	1.找到目标文件
 	2.建立数据输出通道
 	3.把数据输出
 	4.关闭资源
 	
 FileWriter要注意的事项：
 	1.使用FileWriter写数据的时候，FileWriter内部是维护了一个1024长度的字符数组的。写数据的时候会先写入到他内部维护的字符数组中，
 	如果需要把数据真正写到硬盘上，需要调用flush或者close方法或者填满了内部的字符数组
 	2.使用FileWriter的时候，如果目标文件不存在，会自动创建目标文件
 	3.使用FileWriter的时候，如果目标文件已经存在，默认情况会先情况文件中的数据，然后再写入数据，如果需要在原理的基础上追加数据，需要
 	使用"new FileWriter(file,boolean)"构造方法，第二个参数为true
 	
 */
public class MyDemo4 {
	public static void main(String[] args) {
		try {
			werterTest1();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void werterTest1() throws IOException {
		//1.找到目标文件
		File file=new File("E:/aaa/ccc.txt");
		//建立数据输出通道
		FileWriter fileWriter=new FileWriter(file,true);
		//准备数据，把数据输出
		String data="今天天气非常好，哈哈！！";
		fileWriter.write(data);//字符流具备解码的功能
		
//		fileWriter.flush();
		//关闭资源
		fileWriter.close();
	}
}
