package com.cl.javabasis.day16genrictiry;

/**
 * 需求：定义一个方法，可以接受任意类型的参数，而且返回值类型必须要与实参类型一致
 * 
 * 自定义泛型：自定义泛型就是一个数据类型的占位符T或者是 一个数据类型的变量T,T可以是String、Integer等
 * 
 * 方法上自定义泛型：
 * 		修饰符 <声明自定义的泛型>返回值类型 函数名(使用自定义泛型...){
 * 		}
 * 	
 * 注意：在泛型中不能使用基本数据类型，如果要用基本数据类型，那么使用基本数据类型对应的包装类
 * byte--->Byte
 * short--->Short	
 * int---->Integer
 * long---->Long
 * 
 * double---->Double
 * float----->Float
 * 
 * boolean---Boolean
 * 
 * char--->Character
 * 
 * 
 * 方法泛型注意的事项：
 * 		1.在方法上自定义泛型，这个自定义泛型的具体数据类型是在调用该方法的时候传入实参时确定的
 * 		2.自定义泛型只要符合标识符的命名即可。但是我们一般都习惯使用一个大写字母表示。T Type E Element
 */
public class MyDemo2 {

	public static void main(String[] args) {
		String str=getDate("aa");
		Integer i=getDate(123);
	}
	
	public static <T>T getDate(T object){

		return object;
	}
}
