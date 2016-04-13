package com.cl.javabasis.day21;
/*
 字节流： 

输入字节流
	-----------| InputStream 输入字节流的基类   抽象类
	----------------| FileInputStream 读取文件数据的输入字节流。
	----------------| BufferedInputStream 缓冲输入字节流       缓冲输入字节流出现的目的： 为了提高读取文件数据的效率。 该类其实内部就是维护了一个8kb字节数组而已。
 
输出字节流：
	---------| OutputStream 输出字节流的基类。  抽象类。
	--------------| FileOutStream  向文件输出数据的输出字节流。
	--------------| BufferedOutputStream 缓冲输出字节流。  该类出现的目的是为了提高写数据的效率 。 其实该类内部也是维护了一个8kb的数组而已，当
	调用其write方法的时候数据默认是向它内部的数组中存储 的，只有调用flush方法或者是close方法或者是8kb的字节数组存储满数据的时候才会真正的向硬盘输出。
 */
public class MyDemo1 {

}
