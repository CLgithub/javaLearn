package com.cl.javabasis.day20;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
  练习：使用缓存输入输出字节流拷贝一个图片
  输入流可以自己用字节数组
  输出用BufferedOutputStream
 */
public class MyDemo8 {
	public static void main(String[] args) {
		copyImageByBuffer();
	}
	
	public static void copyImageByBuffer() {
		BufferedInputStream bufferedInputStream=null;
		BufferedOutputStream bufferedOutputStream = null;
		try {
			//找到目标文件
			File sourceFile=new File("E:/手机/照片/照片2236.jpg");
			File imageFile=new File("F:/wang1.jpg");
			//建立数据输入输出通道
			FileInputStream fileInputStream=new FileInputStream(sourceFile);
			FileOutputStream fileOutputStream=new FileOutputStream(imageFile);
			//建立缓存输入输出流
			bufferedInputStream=new BufferedInputStream(fileInputStream);
			bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
			//读取数据到缓存输入流 ，将数据写入缓存输出流中
			int content=0;
//			content=bufferedInputStream.read(buf)//内容存入缓存数组，返回存入的字节格式
			while((content=bufferedInputStream.read())!=-1){//内容存入并返回
				bufferedOutputStream.write(content);
			}
//			bufferedOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				if(null!=bufferedOutputStream){
					bufferedOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}finally {
				try {
					if(null!=bufferedInputStream){
						bufferedInputStream.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
		
	}
}
