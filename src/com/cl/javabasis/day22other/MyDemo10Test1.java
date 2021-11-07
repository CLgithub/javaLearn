package com.cl.javabasis.day22other;

import java.io.File;

/*
 需求 1:列出一个文件夹的子孙文件与目录
 
 需求4:删除一个非空的文件夹
 需求5：移动一个非空文件夹
 */
public class MyDemo10Test1 {
	public static void main(String[] args) {
		File dir1=new File("/Users/l/develop/ultrapower/ultrapowerBin/31-G");
		File dir2=new File("/Users/l/develop/ultrapower/ultrapowerBin/31-");
//		method2(dir1,"");
//		method3(dir1);
		method4(dir1, dir2);
	}
	
	/**
	 * 1:列出一个文件夹的子孙文件与目录
	 * @author L
	 * @date 2016年4月22日
	 * @param dir
	 */
	public static void method1(File dir) {
		File[] files=dir.listFiles();
		for(File file:files){
			if(file.isFile()){
				System.out.println("文件名："+file.getName());
			}else if(file.isDirectory()){
				System.out.println("文件夹名："+file.getName());
				method1(file);
			}
		}
	}
	
	/**
	 * 1:列出一个文件夹的子孙文件与目录,有缩进
	 * @author L
	 * @date 2016年4月22日
	 * @param dir
	 */
	public static void method2(File dir,String s) {
		File[] files=dir.listFiles();
		for(File file:files){
			if(file.isFile()){
				System.out.println(s+file.getName());
			}else if(file.isDirectory()){
				System.out.println(s+file.getName());
				method2(file,"--|"+s);
			}
		}
	}

	/**
	 * 需求4:删除一个非空的文件夹
	 * @author L
	 * @date 2016年4月22日
	 * @param dir
	 */
	public static void method3(File dir) {
		File[] files=dir.listFiles();
		if(files!=null){
			for(File file:files){
				if(file.isFile()){
					file.delete();
				}else {
					method3(file);
				}
			}
			dir.delete();
		}
	}
	
	/**
	 * 移动一个非空文件夹
	 * @author L
	 * @date 2016年4月22日
	 * @param dir
	 * @param dir2
	 */
	public static void method4(File dir,File dir2) {
		if(!dir2.exists()){
			dir2.mkdirs();
		}
		File[] files=dir.listFiles();
		for(File file:files){
			if(file.isFile()){
				file.renameTo(new File(dir2.getPath()+"/"+file.getName()));
			}else if(file.isDirectory()){
				method4(file, new File(dir2.getPath()+"/"+file.getName()));
			}
		}
		dir.delete();
	}
}
