package com.cl.javabasis.day22other;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 对象的输入输出流：主要的作用是写对象的信息，与读取对象的信息，对象的信息一旦写到文件上（硬盘），对象到信息就可以做到持久化
 	对象的输出流：ObjectOutputStream
 	对象的输入流：ObjectInputStream
 	
 	ObjectOutputStream的使用步骤：
 		1.找到目标文件
 
 对象输入输出流要注意的细节：
 	1.如果对象要被写到文件上，那么对象所属的类必须要实现Serializable接口，Serializable没有然后方法，只是一个标志而已
 	2.对象的反序列化创建对象的时候并不会调用对象所属类的构造方法
 	3.serialVersionUID 是用于记录class文件的版本信息的，serialVersionUID这个数字是通过一个类名，成员，包名，工程名算出来的一个数字
 	4. 使用ObjectInputStream反序列化的时候，ObjeectInputStream会先读取文件中的serialVersionUID，然后与本地的class文件的serialVersionUID
 	5.如果序列化与反序列化的时候可以会修改类的成员，那么最好一开始就可以给这个类指定一个serialVersionUID，那么在序列化与反序列化的时候，jvm都不会在自己去算这个serialVersionUID了。
 
 */
public class MyDemo3 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//把user对象的信息持久化的存储
//		writeObj();
		readObj();
	}
	
	//定义一个方法把对象的信息写到硬盘上－－－－－对象的序列化
	public static void writeObj() throws IOException {
		User user=new User("admin", "123");
		//1.找到目标文件
		File objF=new File("/Users/L/Downloads/aaa/obj");
		//2.建立数据的输出流通道
		FileOutputStream fileOutputStream=new FileOutputStream(objF);
		//3.建立对象的对象输出流对象
		ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
		//4.把对象写出
		objectOutputStream.writeObject(user);
		//5.关闭资源
		objectOutputStream.close();
	}
	
	//把文件中的对象信息读取出来－－－－－对象的反序列化
	public static void readObj() throws IOException, ClassNotFoundException {
		//1.找到目标文件
		File objF=new File("/Users/L/Downloads/aaa/obj");
		//2.建立数据的输入流通道
		FileInputStream fileInputStream=new FileInputStream(objF);
		//3.建立对象的对象输入流对象
		ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
		//4.读取对象
		User user=(User) objectInputStream.readObject();//创建对象肯定需要对象所属的class文件
		//5.关闭资源
		objectInputStream.close();
		
		System.out.println(user);
	}
}


class User implements Serializable{
	private static final long serialVersionUID = 1L;
	String userName;
	String password;
	int age;

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "[userName=" + userName + ", password=" + password + ", age=" + age + "]";
	}

	
	
	
}
