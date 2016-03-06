package com.cl.javabasis.day3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 用异或对图片数据进行加密
 * @author L
 * @date 2016年3月6日
 */
public class ImageTest {
	public static void main(String[] args) {
		try {
			//找到图片文件
			FileInputStream sourceImage=new FileInputStream("f:/imageTest.jpg");
			FileOutputStream passImage=new FileOutputStream("f:/image1.jpg");
			int key=123;
			
//			long size=imageTest.getFreeSpace();
//			byte[] b=new byte[size];
//			fileInputStream.read(b);
//			System.out.println(new String(b,0,b.length));
//			fileOutputStream.write(b);
			
			
			//边读边写
			int content=0;//该变量用于存储读取到的数据
			while((content=sourceImage.read())!=-1){//
				passImage.write(content^key);
			}
			sourceImage.close();
			passImage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
