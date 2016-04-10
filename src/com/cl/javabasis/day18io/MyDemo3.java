package com.cl.javabasis.day18io;

import java.io.File;
import java.io.IOException;

/*
 创建：
	createNewFile()	在指定位置创建一个空文件，成功就返回true，如果已存在就不创建然后返回false
	mkdir()			在指定位置创建目录，这只会创建最后一级目录，如果上级目录不存在就抛异常。
	mkdirs()		在指定位置创建目录，这会创建路径中所有不存在的目录。
	renameTo(File dest)	重命名文件或文件夹，也可以操作非空的文件夹，文件不同时相当于文件的剪切,剪切时候不能操作非空的文件夹。移动/重命名成功则返回true，失败则返回false。
 * */
public class MyDemo3 {
	public static void main(String[] args) throws IOException {
		File file=new File("E:/ccc");
		System.out.println("创建文件成功了吗："+file.createNewFile());//创建一个指定的文件，如果该问存在了，就不会再创建，否则就创建，创建成功true，否则false
		
		File dir=new File("E:/aaa");
//		File dir2=new File("E:/x.txt");
		System.out.println("创建文件夹成功了吗："+dir.mkdir());//创建一个单级文件夹
		
		File dirs=new File("E:/bbb/bbb");
		System.out.println(""+dirs.mkdirs());
		
		//renameTo(File dest)	如果目标文件与源文件在同一个路径下，那么是重命名，如果不在同一个路径，那么就是移动，而且不在同一个磁盘下时不能操作文件夹，只能存在文件，相当于rm命令
		File destFile=new File("F:/ddd");
		System.out.println("重命名成功吗："+file.renameTo(destFile));//
	}
}
