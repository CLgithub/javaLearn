package com.cl.learn.api;

public class Mykey {
	private String name;
	private int age;
	public Mykey(String name,int age){
		this.name=name;
		this.age=age;
	}
	@Override
	public String toString() {
		return new String(name+","+age);
	}
	
	public boolean equals(Mykey obj){
		if(name.equals(obj.name)&&age==obj.age){
			return true;
		}else {
			return false;
		}
	}
	public int hashCode(){
		return name.hashCode()+age;
	}
	
}
