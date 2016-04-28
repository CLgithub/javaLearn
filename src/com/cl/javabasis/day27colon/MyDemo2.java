package com.cl.javabasis.day27colon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/*
 对象的深克隆：对象的深克隆就是利用对象的输入输出流把对象先写到文件上，然后再对取对象的信息，这个过程就是对象的深克隆
 
 
 */
public class MyDemo2 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Address address=new Address("广州");
		Person p1=new Person(110, "小明", address);
		writeObj(p1);
		Person p2=readObj();
		p2.address.aName="长沙";
		
		System.out.println("p1:"+p1);
		System.out.println("p2:"+p2);
	}
	
	//把对象读回来
	public static Person readObj() throws ClassNotFoundException, IOException {
		ObjectInputStream oInputStream=new ObjectInputStream(new FileInputStream("/Users/L/Downloads/aaa/oosClone"));
		Person person=(Person) oInputStream.readObject();
		return person;
	}
	
	//把对象写到文件上
	public static void writeObj(Person person) throws IOException {
		ObjectOutputStream ooStream=new ObjectOutputStream(new FileOutputStream("/Users/L/Downloads/aaa/oosClone"));
		//把对象写出
		ooStream.writeObject(person);
//		ooStream.flush();
		ooStream.close();
	}
}
