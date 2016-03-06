package com.cl.javabasis.day3;

/**
 * 
 * @author L
 * @date 2016年3月6日
 * 
 * java中的八种基本数据类型
 * 整形：byte(8)、short(16)、int(32)、long(64)
 * 浮点：float(32)、double(64)
 * 字符：char(16)
 * 布尔：boolean
 * 
 * 数据类型转换
 * 小数据类型-------->大数据类型	自动类型转换
 * 大数据类型-------->小数据类型
 */
public class Demo2 {
	public static void main(String[] args) {
		/*byte b=11;
		short s=b;
		int i=s;
		long l=i;
		System.out.println(l);*/
		
		int i=256;	//32位
		byte b=(byte) i;	//8位
		System.out.println(b);
	}
}
