package com.cl.javabasis.day20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/*
 
 问题1：读取完一个文件的数据之后，不关闭资源有什么影响
	如果不释放资源，其他程序无法操作该文件
	
问题2：
 
*/
public class MyDemo2 {
	public static void main(String[] args) throws IOException {
		//找到目标文件
		File file=new File("E:/aaa/aaa.txt");
		//建立数据的输入通道
		FileInputStream fileInputStream=new FileInputStream(file);
		//
		byte[] buf=new byte[4];
		int leng=0;
		while((leng=fileInputStream.read(buf))!=-1){
//			System.out.println(new String(buf,0,leng));
			System.out.println(Arrays.toString(buf));//每次读取数据放入buf都是覆盖，
		}
		System.out.println("读取文件资源完毕");
		fileInputStream.close();
	}
}
