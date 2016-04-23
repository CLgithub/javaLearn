package com.cl.javabasis.day23tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 2.  实现登陆与注册 功能。  
	客户端与服务端连接的时候，就要提示客户端请选择功能。
	客户端注册的时候，用户名与密码都是发送给服务端 的，服务端需要把数据保存到服务端的文件上。
	登陆： 登陆的时候客户端输入用户名与密码发送给服务端，服务端需要校验，返回结果给客户端。
 */
public class Zuoye2 {
	public static void main(String[] args) throws IOException {
		File file=new File("/Users/L/Downloads/aaa/userInfoDB");	//用个文件来存储userinfo
		
		ServerSocket serverSocket=new ServerSocket(8099);
		Socket socket=null;
		boolean flag=true;
		while(flag){
			socket=serverSocket.accept();
			MyServer myServer=new MyServer(socket,file);
			myServer.start();
		}
		serverSocket.close();
	}
}
class MyServer extends Thread{
	private Socket socket;
	private BufferedWriter dbWriter;
	private BufferedReader dbReader;
	

	public MyServer(Socket socket, File file) {
		try {
			this.dbWriter=new BufferedWriter(new FileWriter(file,true));
			this.dbReader=new BufferedReader(new FileReader(file));
			this.socket = socket;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(true){
			try {
				BufferedReader socketIn=new BufferedReader(new InputStreamReader(socket.getInputStream()));//获取socket输入
				BufferedWriter socketOut=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));//获取socket输出
				if(socket.isConnected()){
					System.out.println("MyServer.run()");
				}
				
				socketOut.write("请选择功能：A注册，B登陆\r\n");//提示客户端操作
				socketOut.flush();
				String str1=socketIn.readLine();//获得客户端选择的功能
				if("A".equalsIgnoreCase(str1)){//注册
					method1(socketIn,socketOut,dbReader,dbWriter);
				}else if("B".equalsIgnoreCase(str1)){//登陆
					method2(socketIn,socketOut,dbReader,dbWriter);
				}else {
					socketOut.write("输入有误，请重新输入\r\n");
					socketOut.flush();
				}
			}catch (IOException e) {
				e.printStackTrace();
				break;
//				dbWriter.close();
//				dbReader.close();
			}
		}
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				dbReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					dbWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	/**
	 * 注册
	 * @param socketIn
	 * @param socketOut
	 * @author L
	 * @param dbWriter 
	 * @param dbReader 
	 * @throws IOException 
	 * @date 2016年4月23日
	 */
	private void method1(BufferedReader socketIn, BufferedWriter socketOut, BufferedReader dbReader, BufferedWriter dbWriter) throws IOException {
		socketOut.write("注册：请输入注册用户名\r\n");
		socketOut.flush();
		
		String userName=socketIn.readLine();//读取客户端输入的用户名
		String password="";
		String userInfo="";
		boolean flag=false;
		//判断用户名是否已经被用
		while((userInfo=dbReader.readLine())!=null){
			if(userInfo.split(",")[0].equals(userName)){//如果有同名
				flag=true;
				break;
			}
		}
		if(flag){//如果被用
			socketOut.write("用户名已经被使用\r\n");
			socketOut.flush();
		}else {//如果没有被用
			socketOut.write("注册：请输入注册密码\r\n");
			socketOut.flush();
			password=socketIn.readLine();
			socketOut.write("注册成功\r\n");
			socketOut.flush();
			//写入文件
			dbWriter.write(new User(userName, password).toString());
			dbWriter.newLine();
			dbWriter.flush();
		}
	}
	
	/**
	 * 登陆
	 * @param socketIn
	 * @param socketOut
	 * @author L
	 * @param dbWriter 
	 * @param dbReader 
	 * @throws IOException 
	 * @date 2016年4月23日
	 */
	private void method2(BufferedReader socketIn, BufferedWriter socketOut, BufferedReader dbReader, BufferedWriter dbWriter) throws IOException {
		socketOut.write("登陆：请输入登陆用户名\r\n");
		socketOut.flush();
		String userName=socketIn.readLine();//读取客户端输入的用户名
		socketOut.write("登陆：请输入登陆密码\r\n");
		socketOut.flush();
		String password=socketIn.readLine();//读取客户端输入的密码
		
		String userInfo="";
		boolean falg=false;
		while((userInfo=dbReader.readLine())!=null){
			if(userInfo.equals(new User(userName, password).toString())){
				falg=true;
			}
		}
		if(falg){
			socketOut.write("用户"+userName+"登陆成功\r\n");
			socketOut.flush();
		}else {
			socketOut.write("用户名或密码错误，登陆失败\r\n");
			socketOut.flush();
		}
	}
	
}
class User{
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	@Override
	public String toString() {
		return userName+","+password;
	}
	
}
