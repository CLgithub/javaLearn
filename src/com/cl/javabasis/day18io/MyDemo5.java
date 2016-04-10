package com.cl.javabasis.day18io;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
获取：
	getName()		获取文件或文件夹的名称，不包含上级路径。
	getPath()       返回绝对路径，可以是相对路径，但是目录要指定
	getAbsolutePath()	获取文件的绝对路径，与文件是否存在没关系
	length()		获取文件的大小（字节数），如果文件不存在则返回0L，如果是文件夹也返回0L。
	getParent()		返回此抽象路径名父目录的路径名字符串；如果此路径名没有指定父目录，则返回null。
	lastModified()	获取最后一次被修改的时间。
	
文件夹相关：
	staic File[] listRoots()	列出所有的根目录（Window中就是所有系统的盘符）
	list()						返回目录下的文件或者目录名，包含隐藏文件。对于文件这样操作会返回null。
	list(FilenameFilter filter)	返回指定当前目录中符合过滤条件的子文件或子目录。对于文件这样操作会返回null。
	listFiles()					返回目录下的文件或者目录对象（File类实例），包含隐藏文件。对于文件这样操作会返回null。
	listFiles(FilenameFilter filter)	返回指定当前目录中符合过滤条件的子文件或子目录。对于文件这样操作会返回null。
 */
public class MyDemo5 {
	public static void main(String[] args) {
		File file=new File("E:/a.txt");
		System.out.println("获取文件名："+file.getName());
		System.out.println("返回绝对路径:"+file.getPath());
		System.out.println("获取文件的绝对路径:"+file.getAbsolutePath());
		System.out.println("获取文件的字节大小："+file.length());
		System.out.println("获取文件的名父目录："+file.getParent());
		SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("获取文件的最后一次修改时间（毫秒值）："+sDateFormat.format(new Date(file.lastModified())));
	}
}
