package com.cl.javabasis.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
作业2：使用集合实现注册登陆功能，

第一步： 提示用户选择功能， A（注册）  B(登陆) 。 要求： 功能选择 的时候要忽略大小写。

注册：
	1. 提示用户输入注册的账号(数字)与密码，如果输入的id号已经存在集合中，提示用户重新输入。 注册完毕之后，把集合中的所有用户信息打印出来。(使用：toArrry()方法)	

登陆： 
	提示用户输入登陆的账号与密码,如果账号与密码这个用户已经存在集合中，那么登陆成功，否则登陆失败。
 */
public class Zuoye {
	public static void main(String[] args) {
		try {
			System.out.println("请选择功能：A（注册）  B(登陆)(忽略大小写)");
			InputStream iStream=System.in;
			BufferedReader bReader=new BufferedReader(new InputStreamReader(iStream));
			 String gn=bReader.readLine();
			if(gn.toUpperCase().equals("A")){
				System.out.println("注册");
			}else {
				System.out.println("Zuoye.main()");
			}
			bReader.close();
			iStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
