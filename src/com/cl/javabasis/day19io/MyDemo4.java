package com.cl.javabasis.day19io;

import java.io.File;

/*
删除：
	delete() 		删除文件或一个空文件夹，如果是文件夹且不为空，则不能删除，成功返回true，失败返回false。
	deleteOnExit()	在虚拟机终止时，请求删除此抽象路径名表示的文件或目录，保证程序异常时创建的临时文件也可以被删除

判断：
	exists()		文件或文件夹是否存在。
	isFile()		是否是一个文件，如果不存在，则始终为false。
	isDirectory()	是否是一个目录，如果不存在，则始终为false。
	isHidden()		是否是一个隐藏的文件或是否是隐藏的目录。
	isAbsolute()	测试此抽象路径名是否为绝对路径名。
*/
public class MyDemo4 {
	public static void main(String[] args) {
		//删除
//		File file=new File("E:/bbb/bbb");
//		System.out.println("删除成功吗："+file.delete());//delete方法不能用于删除非空的文件夹,delete方法会马上删除文件
//		File file=new File("E:/a.txt");
//		file.deleteOnExit();//java虚拟机退出的时候删除文件，一般用于删除临时文件
		
		//判断
		File file=new File("E:/a.txt");
		System.out.println("存在吗?"+file.exists());
		System.out.println("是否是一个文件?"+file.isFile());
		System.out.println("是否是一个文件夹?"+file.isDirectory());
		System.out.println("是否是一个隐藏文件或者隐藏文件夹?"+file.isHidden());
		System.out.println("是否为绝对路径名?"+file.isAbsolute());
		
	}
}
