package com.cl.javabasis.day21;
/*
 
 File类可以描述一个文件或者一个文件夹
 
 File类的方法：
 创建：
	createNewFile()	在指定位置创建一个空文件，成功就返回true，如果已存在就不创建然后返回false
	mkdir()			在指定位置创建目录，这只会创建最后一级目录，如果上级目录不存在就抛异常。
	mkdirs()		在指定位置创建目录，这会创建路径中所有不存在的目录。
	renameTo(File dest)	重命名文件或文件夹，也可以操作非空的文件夹，文件不同时相当于文件的剪切,剪切时候不能操作非空的文件夹。移动/重命名成功则返回true，失败则返回false。
 删除：
	delete() 		删除文件或一个空文件夹，如果是文件夹且不为空，则不能删除，成功返回true，失败返回false。
	deleteOnExit()	在虚拟机终止时，请求删除此抽象路径名表示的文件或目录，保证程序异常时创建的临时文件也可以被删除

判断：
	exists()		文件或文件夹是否存在。
	isFile()		是否是一个文件，如果不存在，则始终为false。
	isDirectory()	是否是一个目录，如果不存在，则始终为false。
	isHidden()		是否是一个隐藏的文件或是否是隐藏的目录。
	isAbsolute()	测试此抽象路径名是否为绝对路径名。
 获取：
	getName()		获取文件或文件夹的名称，不包含上级路径。
	getPath()       返回绝对路径，可以是相对路径，但是目录要指定
	getAbsolutePath()	获取文件的绝对路径，与文件是否存在没关系
	length()		获取文件的大小（字节数），如果文件不存在则返回0L，如果是文件夹也返回0L。
	getParent()		返回此抽象路径名父目录的路径名字符串；如果此路径名没有指定父目录，则返回null。
	lastModified()	获取最后一次被修改的时间。
	
文件夹相关：
	staic File[] listRoots()	列出所有的根目录（Window中就是所有系统的盘符）
	list()						返回目录下的文件或者目录名，包含隐藏文件。对于文件这样操作会返回null。有点像ls命令
	list(FilenameFilter filter)	返回指定当前目录中符合过滤条件的子文件或子目录。对于文件这样操作会返回null。
	listFiles()					返回目录下的文件或者目录对象（File类实例），包含隐藏文件。对于文件这样操作会返回null。
	listFiles(FilenameFilter filter)	返回指定当前目录中符合过滤条件的子文件或子目录。对于文件这样操作会返回null。
	list(FilenameFilter filter)	返回指定当前目录中符合过滤条件的子文件或子目录。对于文件这样操作会返回null。
 	listFiles(FilenameFilter filter)	返回指定当前目录中符合过滤条件的子文件或子目录。对于文件这样操作会返回null。
 
 
 IO流分类：
 	如果按照数据流向划分：输入输出是相对于当前程序来说
 		1.输入流：
 		2.输出流：
 	如果按照处理单元划分：
 		1.字节流：读取的都是文件中的二进制数据，而且读出的二进制数据不会经过任何处理
 		2.字符流：读取的数据是以字符为单位的，也是读取文件中的二进制数据，不过会把这些二进制数据转换成我们能识别的字符。
 					100101000101010101--------->字符char
 					字符流=字节流+解码
 
 字节流
	 -----| InputStream		所以字节输入流的基类	抽象类
	 -----| OutputStream	所有字节输出流的父类	抽象类
	 ----------| FileInputStream	文件字节输入流
	 ----------| FileOutputStream	文件字节输出流
				FileOutputStream要注意的细节：
				 	1.使用FileOutputStream的时候，如果目标文件不存在，那么就会自动创建目标文件
				 	2.使用FileOutputStream写数据的时候，如果目标文件已经存在，那么会先把文件的数据清空，然后再写入数据
				 	3.使用FileOutputStream写数据的时候，如果目标文件已经存在，需求在原来的基础上追加数据，需要使用new FileOutputStream(file, true)构造方法，第二个参数为true
				 	4.使用FileOutputStream的write()方法写数据的时候，虽然接收的是一个int（32位）类型的数据，但是真正写出的只是一个字节的数据，只是
				 	把低八位的二进制数据写出，其他二十四位数据全部丢弃
				 	
	  注意：凡是缓存流都不具备读写数据的能力。
	 ----------| BufferedInputStream	缓存输入字节流	缓存输入字节流的出现主要是为了提高读取文件数据的效率。其实 该类内部只不过是维护了一个8kb的字节数组而已。
	 ----------| BufferedOutputStream	缓存输出字节流	内部也是维护了一个8kb的字节数组而已
					  BufferedOutputStream要注意的细节
					 	1.使用BufferedOutputStream写数据的时候，它的write方法是先把数据写到他内部维护的字节数组中
					 	2.使用BufferedOutputStream写数据的时候，它的write方法是先把数据写到他内部维护的字节数组中，如果需要把数据真正的写到硬盘上，
					 	需要调用flush或close方法，或者是内部维护的自己数组已经填满数据的时候

 字符流
 	-----| Reader	字符输入流的基类	抽象类
 	-----| Writer	字符输出流的基类	抽象流
 	----------| FileReader	文件字符输入流
 	----------| FileWriter	文件字符输出流
				FileWriter要注意的事项：
					1.使用FileWriter写数据的时候，FileWriter内部是维护了一个1024长度的字符数组的。写数据的时候会先写入到他内部维护的字符数组中，
					如果需要把数据真正写到硬盘上，需要调用flush或者close方法或者填满了内部的字符数组
					2.使用FileWriter的时候，如果目标文件不存在，会自动创建目标文件
					3.使用FileWriter的时候，如果目标文件已经存在，默认情况会先情况文件中的数据，然后再写入数据，如果需要在原理的基础上追加数据，需要
					使用"new FileWriter(file,boolean)"构造方法，第二个参数为true
					
	注意：凡是缓存流都不具备读写数据的能力。
 	----------| BufferedReader	缓存字符输入流	缓存字符输入流出现的目的是为了提高读取文件字符的效率和拓展了FileReader的功能。其实该类内部也是维护了一个字符数组（8k字符）
 	----------| BufferedWriter 缓存输出字符流	缓存输出字符流作用：提高FileWriter的写字符数据的效率与拓展FileWriter的功能。
 					BufferedWriter内部只不过是提供了一个8192长度(8k)的字符数组作为缓冲区而已，拓展了FileWriter的功能。
 */
public class IOzj {

}
