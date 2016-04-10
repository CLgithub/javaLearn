package com.cl.javabasis.day19io;

import java.io.File;
import java.nio.file.FileSystem;
import java.util.Arrays;

/*
  文件夹相关：
	staic File[] listRoots()	列出所有的根目录（Window中就是所有系统的盘符）
	list()						返回目录下的文件或者目录名，包含隐藏文件。对于文件这样操作会返回null。
	list(FilenameFilter filter)	返回指定当前目录中符合过滤条件的子文件或子目录。对于文件这样操作会返回null。
	listFiles()					返回目录下的文件或者目录对象（File类实例），包含隐藏文件。对于文件这样操作会返回null。
	listFiles(FilenameFilter filter)	返回指定当前目录中符合过滤条件的子文件或子目录。对于文件这样操作会返回null。
*/
public class MyDemo6 {
	public static void main(String[] args) {
//		File[] roots=File.listRoots();//列出所有的根目录
//		System.out.println(Arrays.toString(roots));
		
		File file=new File("E:/aaa");
//		String[] fileNames=file.list();//把文件夹下面的所有子文件名子文件夹名存储到一个String类型数组中返回（隐藏也可以）。有点像ls命令
//		System.out.println(Arrays.toString(fileNames));
		
//		File[] files=file.listFiles();//把文件夹下面的所有子文件子文件夹存储到一个File类型数组中返回（隐藏也可以）
//		for(File file2:files){
//			System.out.println(file2.getName());
//		}
	}
	
	
	
}
