package com.cl.javabasis.day16genrictiry;

import java.util.Set;

/**
 * 泛型接口
 * 
 * 泛型接口的定义格式：
 * 		interface 接口名<声明自定义泛型>{
 * 		}
 * 
 * 泛型接口要注意的问题：
 * 	1.接口上自定义的泛型的具体数据类型是在实现接口的时候指定的
 * 	2.接口上自定义的泛型，在实现接口时如果不指定具体数据类型，默认为Object类型
 * 
 * 
 * 需求：目前我实现一个接口的时候我还不明确要操作的数据类型。我要等到
 * 	创建接口类对象的时候我才能指定泛型的具体数据类型
 * 		如果要延迟接口自定义泛型的具体数据类型是指定，那么格式如下：
 * 			class UserDao<T> implements Dao<T>{
 * 			}
 * 
 * 
 */
public class MyDemo4 {
	public static void main(String[] args) {
		//就可以在这指定
		UserDao<User> userDao=new UserDao<User>();
	}
}

interface Dao<T>{
	public void add(T t);
}

class UserDao<T>/*3*/ implements Dao<T>{/*1*/
	@Override
	public void add(T t) {/*2*/
	}
}
class User{
}