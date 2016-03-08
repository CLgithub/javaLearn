package com.cl.javabasis.day5;

/*
 * 成员变量与局部变量的区别：
	1.应用范围  
		1.成员变量在整个类内都有效    
		2.局部变量只在其声明的方法内有效
	2.生命周期  
		1.成员变量: 它属于对象，它随着对象的创建而创建，随着对象的消失而消失 
		2.局部变量: 使用完马上释放空间。
					void show(int id){	
						for(int i=0;i<10;i++){
						 	for(int j=0;j<10;j++){
								System.out.println(id);
							}
						}
					}
					这时候  id,i,j者是在方法内声明的，全是局部变量
					j当里层for循环执行它的生命周期开始，当里层for结束，j消失
					i当外层for循环执行它的生命周期开始，当外层for结束，i消失
					id在方法被调用时开始，方法结束时，id消失.
	3.存储位置  成员变量属于对象，它存储在堆内，堆内的实体，当没有引用指向其时，
		才垃圾回收清理 局部变量存在栈内存中，当不在使用时，马上就会被释放。
	4.初始值 
		（1）成员变量它存储在堆中，如果没有赋初值，它有默认值。
			1.整数byte、short、int、long =0；
			2.char=;
			3.boolean =flase；
			4.String =null;
			5.类类型 =null；
			6.数组 =null；
		（2）局部变量，如果要想使用必须手动初始化.
				i.方法中，参数列表中，语句中。
				ii.必须给初始化值，没有初始值，不能使用
				iii.在栈内存中
	局部变量在函数代码块被执行时创建，在函数或代码块结束是被销毁，
	局部变量在进行取值操作前必须被初始化
	*
	*/
public class MyDemo1 {
	static int a1;
	int a3;
	public static void main(String[] args) {
		int a2 = 0;
		System.out.println(a1);
		System.out.println(a2);
	}
	private void method1(){
		int a3=2;
		
	}
}
