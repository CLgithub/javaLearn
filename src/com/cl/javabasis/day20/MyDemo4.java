package com.cl.javabasis.day20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 *  需求：拷贝一张图片
 */
public class MyDemo4 {
	public static void main(String[] args) {
		copyImage();
	}
	
	public static void copyImage() {
		try {
			File sourceFile=new File("E:/手机/照片/照片2236.jpg");
			File imageFile=new File("F:/wang.jpg");
			FileInputStream inputStream=new FileInputStream(sourceFile);
			FileOutputStream outputStream=new FileOutputStream(imageFile);
			
			int leng=0;
			byte[] buf=new byte[1024];
			while((leng=inputStream.read(buf))!=-1){
				outputStream.write(buf);
			}
			inputStream.close();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
