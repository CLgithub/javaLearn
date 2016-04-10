package com.cl.javabasis.day18io;

import java.io.File;

/*
 IO流（Input Output）：
 IO技术主要是作用用于解决设备与设备之间的数据传输问题。
 	比如：硬盘的数据------>内存，内存的数据------>硬盘，键盘数据----->内存...
 
 IO技术的应用场景：
 	导出报表，上传图片，下载，解析xml文件...
 
 数据保存到硬盘上，该数据就可以做到永久性的保存。数据一般是以文件形式保存到硬盘上
 
 sun使用了一个File类描述了文件或者文件夹
 	File类可以描述一个文件或者一个文件夹
 
 
 
File构造方法:
	File(String pathname) 指定文件或者文件夹的路径创建一个File文件 
	File(File parent, String child) 根据父路径 parent 抽象路径名和子路径 child 路径名字符串创建一个新 File 实例。 
	File(String parent, String child) 根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例。 


目录分隔符：在Windowds机器上目录分隔符是“\”，在linux上目录分隔符是“/”

注意：在windows上面\与/都可以使用作为目录分隔符，而且，如果写/的时候只需要写一个即可。


 */
public class MyDemo1 {
	public static void main(String[] args) {
		//1
		File file=new File("E:"+File.separator+"a.txt");//如果在linux机器上就不行
		File file2=new File("E:/a.txt");
//		File file=new File("E:\\win镜像");
		//2
//		File parentFile=new File("E:\\");
//		File file=new File(parentFile, "a.txt");
		//3
//		File file=new File("E:\\","a.txt");
		System.out.println("存在吗？"+file2.exists());//判断该文件是否存在，存在返回true，不存在返回false
		System.out.println("目录分隔符："+File.separator);//windows：\，
	}
}
