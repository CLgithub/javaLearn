package com.cl.javabasis.day22other;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Vector;

/*
 把一首mp3先切割成n份，再合并
 */
public class MyDemo2 {
	public static void main(String[] args) throws IOException {
		method1();
	}
	
	
	public static void method1() throws IOException {
		//找到原文件
		File file=new File("/Users/L/Downloads/aaa/醉清风.mp3");//原文件
		FileInputStream sourceFIS=new FileInputStream(file);
		//根据文件大小，产生对应个数到分解文件
		ArrayList<File> files=new ArrayList<>();
		int i=(int) (file.length()/(1024*1024))+1;//计算得到多少m,加1个文件，每个文件1m
		for(int j=0;j<i;j++){
			File file2=new File("/Users/L/Downloads/aaa/醉清风"+(j+1)+".mp3");
			files.add(file2);
		}
		//为分解文件建立数据输出通道
		ArrayList<FileOutputStream> foss=new ArrayList<>();
		for(File f:files){
			foss.add(new FileOutputStream(f));
		}
		
		
		/************************************分解*************************************/
		for(int k=0;k<foss.size();k++){
			int length=0;
			byte[] buf=new byte[1024*1024];
			length=sourceFIS.read(buf);
			foss.get(k).write(buf,0,length);
//			foss.get(k).close();
		}
		foss.clear();
		
		/************************************合并*************************************/
		//为分解文件建立数据输入通道
		Vector<FileInputStream> fiss=new Vector<>();
		for(File f:files){
			fiss.add(new FileInputStream(f));
		}
		//合并文件
		File file2=new File("/Users/L/Downloads/aaa/醉清风x.mp3");//原文件
		FileOutputStream outputStream2=new FileOutputStream(file2);
		
		SequenceInputStream fInputStream=new SequenceInputStream(fiss.elements());
		int length=0;
		byte[] buf=new byte[1024];
		while((length=fInputStream.read(buf))!=-1){
			outputStream2.write(buf, 0, length);
		}
		
		outputStream2.close();
		fInputStream.close();
		sourceFIS.close();
	}
	
}
