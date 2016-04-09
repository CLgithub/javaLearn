package com.cl.javabasis.day18jdk15;
/*
 jdk1.5新特性之-----枚举
问题： 某些方法接收到数据必须是固定范围内的，
解决方案：自定义一个类，私有化构造函数，对外提供固定的几个对象

jdk1.5对以上问题提出了新的解决方案：使用枚举



 * */
public class MyDemo6 {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setName("小明");
		p1.setSex(Gender.man);
		System.out.println(p1);
	}
}

// 自定义一个性别类
class Gender {
	String value;

	private Gender(String value) {
		this.value = value;
	}
	
	public final static Gender man=new Gender("男");
	public final static Gender woman=new Gender("女");
	
	@Override
	public String toString() {
		return value;
	}
	
}

class Person {
	String name;
	Gender sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getSex() {
		return sex;
	}

	public void setSex(Gender sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", sex=" + sex + "]";
	}
}
