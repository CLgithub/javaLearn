package com.cl.javabasis.day20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 *  需求：拷贝一张图片
 */
public class MyDemo4 {
	public static void main(String[] args) {
		copyImage2();
	}
	
	public static void copyImage() {
		try {
			File sourceFile=new File("E:/手机/照片/照片2236.jpg");
			File imageFile=new File("F:/wang.jpg");
			FileInputStream inputStream=new FileInputStream(sourceFile);
			//每新创建一个FileOutputStream的时候，默认情况下FileOutputStream的指针是指向了文件的开始位置。
			//每次写出一次，指针都会出现相应的移动，加true，光标指向末尾位置（追加）
			FileOutputStream outputStream=new FileOutputStream(imageFile);
			
			int leng=0;
			byte[] buf=new byte[1024];
			while((leng=inputStream.read(buf))!=-1){
				outputStream.write(buf,0,leng);
			}
			//关闭资源	原则：先开后关，后开先关
			outputStream.close();
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//带异常处理的
	public static void copyImage2() {
		FileInputStream inputStream=null;
		FileOutputStream outputStream=null;
		try {
			File sourceFile=new File("E:/手机/照片/照片2236.jpg");
			File imageFile=new File("F:/wang.jpg");
			inputStream=new FileInputStream(sourceFile);
			//每新创建一个FileOutputStream的时候，默认情况下FileOutputStream的指针是指向了文件的开始位置。
			//每次写出一次，指针都会出现相应的移动，加true，光标指向末尾位置（追加）
			outputStream=new FileOutputStream(imageFile);
			
			int leng=0;
			byte[] buf=new byte[1024];
			while((leng=inputStream.read(buf))!=-1){
				outputStream.write(buf,0,leng);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			//关闭资源	原则：先开后关，后开先关
			if(null!=outputStream){
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
			if(null!=inputStream){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
			
		}
	}
}
