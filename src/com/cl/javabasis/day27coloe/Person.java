package com.cl.javabasis.day27coloe;

import java.io.Serializable;

public class Person implements Cloneable,Serializable{
	int id;
	String name;
	Address address;

	public Person(int id, String name,Address address) {
		this.id = id;
		this.name = name;
		this.address=address;
		System.out.println("Person构造方法被调用");
	}

	

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + "]";
	}



	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
}
class Address implements Serializable{
	String aName;

	public Address(String aName) {
		this.aName = aName;
	}

	@Override
	public String toString() {
		return "Address [aName=" + aName + "]";
	}

	
	
}
