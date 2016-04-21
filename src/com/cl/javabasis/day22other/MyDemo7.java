package com.cl.javabasis.day22other;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/*
 编码与解码
 
 编码：字符－－－>码值
 解码：码值－－－>字符
 
 
常见的码表如下：
ASCII：​美国标准信息交换码。用一个字节的7位可以表示。  -128~127  256
ISO8859-1：​拉丁码表。欧洲码表，用一个字节的8位表示。又称Latin-1(拉丁编码)或“西欧语言”。ASCII码是包含的仅仅是英文字母，并且没有完全占满256个编码位置，所以它以ASCII为基础，在空置的0xA0-0xFF的范围内，加入192个字母及符号，
藉以供使用变音符号的拉丁字母语言使用。从而支持德文，法文等。因而它依然是一个单字节编码，只是比ASCII更全面。
GB2312：​英文占一个字节， 中文占两个字节。中国的中文编码表。
GBK：​中国的中文编码表升级，融合了更多的中文文字符号。
 
 
Unicode：  国际标准码，融合了多种文字。所有文字都用两个字节来表示，Java语言使用的就是unicode。
UTF-8：​英文占一个字节，中文占三个字节。​最多用三个字节来表示一个字符。
（我们以后接触最多的是iso8859-1、gbk、utf-8）
 
UTF-16:  不管英文中文都是占两个字节。
 
 ⚠注意：以后编码与解码外面一般都使用统一的码表，否则容易出现乱码
 
 */
public class MyDemo7 {
	public static void main(String[] args) throws IOException {
		method3();
	}
	
	public static void method3() throws IOException {
		String str="大家好";
		byte[] buf=str.getBytes();//用utf－8编码："大家好"－－》buf		1
		System.out.println("用utf－8编码\"大家好\"---"+Arrays.toString(buf));
		str=new String(buf,"iso8859-1");//用iso8859-1解码：buf－－－》å¤§å®¶å¥½		2
		//å¤§å®¶å¥½		还原“大家好”
		System.out.println("用iso8859-1解码buf---"+str);
		
		buf=str.getBytes("iso8859-1");//用iso8859-1编码：å¤§å®¶å¥½－－－》buf		3
		System.out.println("用iso8859-1编码å¤§å®¶å¥½---"+Arrays.toString(buf));
		str=new String(buf);//用utf－8解码：buf－－－》"大家好"		4
		System.out.println("用utf－8解码buf---"+str);
		
		//出现乱码后都可以被还原吗？
	}
	
	public static void method2() throws IOException {
		String str="a中国";//-2, -1, 0, 97, 78, 45, 86, -3
		byte[] buf=str.getBytes("unicode");//编码与解码的时候，如果写unicode实际上就是用了utf－16
		System.out.println("数组的内容:"+Arrays.toString(buf));
	}
	
	//编码与解码
	public static void method1() throws IOException {
		String str="中国";
		byte[] buf=str.getBytes("gbk");//工程编码，用gbk编码
		System.out.println("数组的元素:"+Arrays.toString(buf));
		
		str=new String(buf,"gbk");//用了gbk去解码
		System.out.println("解码后的字符串："+str);
	}
	
	
}
