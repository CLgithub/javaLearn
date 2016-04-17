package com.cl.javabasis.day22;

/*
 
 字节流
 输入字节流
 -----| InputStream		所以字节输入流的基类	抽象类
 ----------| FileInputStream	文件字节输入流
 ----------| BufferedInputStream	缓存输入字节流	缓存输入字节流的出现主要是为了提高读取文件数据的效率。其实 该类内部只不过是维护了一个8kb的字节数组而已。
 输出字节流
 -----| OutputStream	所有字节输出流的父类	抽象类
 ----------| FileOutputStream	文件字节输出流
 ----------| BufferedOutputStream	缓存输出字节流	内部也是维护了一个8kb的字节数组而已
 
 
 字符流：字节流＝字节流＋编码／解码
 输入字符流
 -----| Reader	字符输入流的基类	抽象类
 ----------| FileReader	文件字符输入流
 ----------| BufferedReader	缓存字符输入流	缓存字符输入流出现的目的是为了提高读取文件字符的效率和拓展了FileReader的功能。其实该类内部也是维护了一个字符数组（8k字符）
 输出字符流
 -----| Writer	字符输出流的基类	抽象流
 ----------| FileWriter	文件字符输出流
 ----------| BufferedWriter 缓存输出字符流	缓存输出字符流作用：提高FileWriter的写字符数据的效率与拓展FileWriter的功能。newline
 
 
 
 
 */
public class MyDemo1 {

}
