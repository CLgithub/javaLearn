package com.cl.javabasis.day21other;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 装饰者设计模式：增强一个类的功能，而且还可以让这些装饰类互相装饰
 
 装饰者设计模式的步骤：
 	1.在装饰类的内部维护一个被别装饰类的引用
 	2.让装饰类有一个共同的夫类或者父接口
 	
 	
 
 需求1:编写一个类拓展BufferReader的功能，增强readLine方法的字符串带有行号
 需求2:编写一个类拓展BufferReader的功能，增强readLine方法的字符串带有分号
 需求3:编写一个类拓展BufferReader的功能，增强readLine方法的字符串带有双引号
 
 需求4:编写一个类拓展BufferReader的功能，增强readLine方法的字符串带有行号+分号
 需求5:编写一个类拓展BufferReader的功能，增强readLine方法的字符串带有行号＋双引号
 需求6:编写一个类拓展BufferReader的功能，增强readLine方法的字符串带有分号＋双引号
 需求7:编写一个类拓展BufferReader的功能，增强readLine方法的字符串带有行号+分号＋双引号
 
 继承实现的增强类和修饰模式实现的增强类有何区别？
 	继承实现的增强类：
		优点：代码结构清晰，而且实现简单
		缺点：对于每一个的需要增强的类都要创建具体的子类来帮助其增强，这样会导致继承体系过于庞大。
	修饰模式实现的增强类：
		优点：内部可以通过多态技术对多个需要增强的类进行增强，可以让这些装饰类达到互相装饰的效果，使用比较灵活
		缺点：需要内部通过多态技术维护需要增强的类的实例。进而使得代码稍微复杂。

练习：
	一家三口每个人都会工作，儿子的工作是画画，母亲的工作是在儿子的基础上做一个增强，不单止可以画画，还可以上涂料，爸爸单工作就是在妈妈基础上增强，就是上画框
 
 */
public class MyDemo2 {
	public static void main(String[] args) throws IOException {
		File file=new File("/Users/L/Downloads/aaa/bbb");
		FileReader fileReader=new FileReader(file);
		String line="";
		Buffered1_2 mybuffer1=new Buffered1_2(new BufferedReader(fileReader));	//需求1
		Buffered2_2 mybuffer2=new Buffered2_2(new BufferedReader(fileReader));	//需求2
		Buffered3_2 mybuffer3=new Buffered3_2(new BufferedReader(fileReader));	//需求3
		Buffered2_2 mybuffe4=new Buffered2_2(mybuffer1);						//需求4
//		Buffered3_2 mybuffe5=new Buffered3_2(mybuffer1);						//需求5
//		Buffered3_2 mybuffe6=new Buffered3_2(mybuffer2);						//需求6
		Buffered3_2 mybuffer7=new Buffered3_2(mybuffe4);						//需求7
		
		while((line=mybuffer7.readLine())!=null){
			System.out.println(line);
		}
		fileReader.close();
	}
}
//需求1
class Buffered1_2 extends BufferedReader{	//继承是为了这些装饰类的对象可以作为参数传递，便于相互装饰
	//在内部维护一个被装饰类的引用
	BufferedReader bufferedReader;
	public Buffered1_2(BufferedReader b) {
		super(b);//该语句没有如何作用，只不过是为了让代码不报错，因为父类BufferedReader没有无参构造方法，子类构造方法要重写父类构造方法
		this.bufferedReader=b;
	}
	int lineNum=0;
	public String readLine() throws IOException {
		lineNum++;
		String str1=bufferedReader.readLine();
		if(str1==null){
			return null;
		}
		return lineNum+":"+str1;
	}
}
//需求2
class Buffered2_2  extends BufferedReader{
	//在内部维护一个被装饰类的引用
	BufferedReader bufferedReader;
	public Buffered2_2(BufferedReader b) {
		super(b);
		this.bufferedReader=b;
	}
	public String readLine() throws IOException {
		String str1=bufferedReader.readLine();
		if(str1==null){
			return null;
		}
		return str1+";";
	}
}
//需求3
class Buffered3_2  extends BufferedReader{
	//在内部维护一个被装饰类的引用
	BufferedReader bufferedReader;
	public Buffered3_2(BufferedReader b) {
		super(b);
		this.bufferedReader=b;
	}
	public String readLine() throws IOException {
		String str1=bufferedReader.readLine();
		if(str1==null){
			return null;
		}
		return "\""+str1+"\"";
	}
}
////需求4
//class Buffered4 extends BufferedReader{
//	BufferedReader bufferedReader;
//	public Buffered4(BufferedReader b) {
//		super(b);
//		this.bufferedReader =  b;
//	}
//	public String readLine() throws IOException {
//		String str1=bufferedReader.readLine();
//		if(str1==null){
//			return null;
// 		}
//		return str1+";";
//	}
//}
