package com.cl.javabasis.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import javax.security.auth.login.LoginContext;

/**
作业2：使用集合实现注册登陆功能，

第一步： 提示用户选择功能， A（注册）  B(登陆) 。 要求： 功能选择 的时候要忽略大小写。

注册：
	1. 提示用户输入注册的账号(数字)与密码，如果输入的id号已经存在集合中，提示用户重新输入。 注册完毕之后，把集合中的所有用户信息打印出来。(使用：toArrry()方法)	

登陆： 
	提示用户输入登陆的账号与密码,如果账号与密码这个用户已经存在集合中，那么登陆成功，否则登陆失败。
 */
public class Zuoye {
	private static Collection<User> c; 
	public static void main(String[] args) {
		c=new ArrayList<>();
		Scanner scanner=new Scanner(System.in);
		while (true){
			System.out.println("请选择功能：A（注册）  B(登陆)(忽略大小写)");
			String gn=scanner.next();
			if("A".equalsIgnoreCase(gn)){
				register(scanner);//注册
			}else if("b".equalsIgnoreCase(gn)){
//				System.out.println("请输入注册的账号和密码");
				login(scanner);//
			}else {
				System.out.println("输入有误 ");
			}
		}
	}

	/**
	 * 登陆
	 * @author L
	 * @date 2016年3月30日
	 * @param scanner
	 */
	private static void login(Scanner scanner) {
		System.out.println("请输入登录账号");
		Integer userid=scanner.nextInt();
		System.out.println("请输入登录密码");
		String password=scanner.next();
		Iterator it=c.iterator();
		boolean b=false;
		while(it.hasNext()){
			User user=(User) it.next();
			if(user.getUserid().equals(userid)&&user.getPassword().equals(password)){
				b=true;
			}
		}
		if(b){
			System.out.println("登陆成功");
		}else {
			System.out.println("登陆失败");
		}
	}

	/**
	 * 注册
	 * @author L
	 * @date 2016年3月30日
	 */
	private static void register(Scanner scanner) {
		User nUser=null;
		while(true){
			System.out.println("请输入注册的账号");
			int userid=scanner.nextInt();
			nUser=new User(userid, null);
			if(c.contains(nUser)){
				System.out.println("id号已经存在,请重新输入");
			}else {
				break;
			}
		}
		System.out.println("请输入注册的密码");
		String password=scanner.next();
		nUser.setPassword(password);
		c.add(nUser);
		System.out.println("注册成功");
		System.out.println("注册信息为："+nUser);
		System.out.println("此时已经注册的用户有："+c);
	}
	
}
class User{
	Integer userid;
	String password;
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(Integer userid, String password) {
		this.userid = userid;
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", password=" + password + "]";
	}
	@Override
	public boolean equals(Object obj) {
		User user=(User) obj;
		return user.userid.equals(this.userid);
	}
	
}
