package com.cl.learn.iotest.bytestream;

import java.io.File;
import java.io.IOException;

/**
 * java学习，IO，file类
 * @author L
 * @date 2016年2月18日
 */
public class FileTest {
	/**
	 * 判断一个文件是否存在，存在则删除，不存在则创建
	 * @author L
	 * @date 2016年2月18日
	 * @param args
	 */
	public static void main(String[] args) {
		//windows
		File file = new File("e:/1.txt");
		//osx
//		File file = new File("/Users/L/Desktop/1.txt");
		if (file.exists()) {
			file.delete();
		} else {
			try {
				file.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getParent());
		System.out.println(file.exists()?"exists":"does not exist");
		System.out.println(file.canWrite());
		System.out.println(file.canRead());
		System.out.println(file.isDirectory());
		System.out.println(file.isFile());
		//返回一个字符串,其中包含了当前文档的最后修改日期和时间.
		System.out.println(file.lastModified());
		System.out.println(file.length());
		
	}
}
