package com.cl.javabasis.day19io;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
/*
 list(FilenameFilter filter)	返回指定当前目录中符合过滤条件的子文件或子目录。对于文件这样操作会返回null。
 listFiles(FilenameFilter filter)	返回指定当前目录中符合过滤条件的子文件或子目录。对于文件这样操作会返回null。
 * */
public class MyDemo7 {
	public static void main(String[] args) {
//		method1();
//		method2();
		method1_2();
	}
	
	//需求1：指定一个文件夹，列出该文件夹下所有java文件。
	public static void method1(){
		File dir=new File("D:/Tomcat 8.0/work/Catalina/localhost/gzszcrm/org/apache/jsp/yxzx");
		File[] files=dir.listFiles();
		for(File file:files){
			if(file.getName().endsWith(".java")&&(file.isFile())){
				System.out.println(file.getName());
			}
			//用正则表达式
//			if((file.isFile())&&(file.getName().matches(".+\\.java"))){
//				System.out.println(file.getName());
//			}
		}
	}
	
	public static void method1_2(){
		File dir=new File("D:/Tomcat 8.0/work/Catalina/localhost/gzszcrm/org/apache/jsp/yxzx");
//		File[] files=dir.listFiles();//得到所有的子文件和子文件夹
		File[] files2=dir.listFiles(new MyFileFilter());
		for(File file:files2){
			System.out.println(file.getName());
		}
	}
	
	
	//需求2：指定一个文件夹，列出该文件夹下的所有子文件与文件夹，格式如下：
	/*
	 文件：
	 	文件名1
	 	文件名2
	 	文件名3
	 	...
	  文件夹：
	 	文件夹名1
	 	文件夹名2
	 	文件夹名3
	 	...
	 */
	public static void method2(){
		File dir=new File("D:/Tomcat 8.0/work/Catalina/localhost/gzszcrm/org/apache/jsp");
		File[] files=dir.listFiles();
		System.out.println("文件：");
		for(File file:files){
			if(file.isFile()){
				System.out.println("\t"+file.getName());
			}
		}
		System.out.println("文件夹：");
		for(File file:files){
			if(file.isDirectory()){
				System.out.println("\t"+file.getName());
			}
		}
	}
}
//自定义一个文件名过滤器
class MyFileNameFilter implements FilenameFilter{

	/**
	 * @param dir 该文件目录
	 * @param name 文件名
	 * @return true通过，false不通过
	 */
	@Override
	public boolean accept(File dir, String name) {
//		System.out.println(dir);
		return name.endsWith(".java");
	}
}
//自定义一个文件过滤器
class MyFileFilter implements FileFilter{

	@Override
	public boolean accept(File pathname) {
//		System.out.println(pathname);
		return pathname.isFile()&&pathname.getName().endsWith(".java");
	}

	
}
