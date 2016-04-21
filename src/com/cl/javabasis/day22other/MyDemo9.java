package com.cl.javabasis.day22other;

/*
 递归：函数自己调用自己
 
 递归的使用前提：必须要用条件的情况下调用
 
 需求：算出5的阶乘 5！
 */
public class MyDemo9 {
	public static void main(String[] args) {
		method1(5);
		method2(5,1);
		System.out.println(method3(5));
	}
	
	//需求1:算阶乘 n!
	public static void method1(int n) {
		int reuslt=1;
		while(n>0){
			reuslt=reuslt*n;
			n--;
		}
		System.out.println(reuslt);
	}
	
	//需求1:算阶乘 n!
	public static void method2(int n, int reuslt) {
		reuslt=reuslt*n;
		n--;
		if(n>0){
			method2(n,reuslt);
		}else {
			System.out.println(reuslt);
		}
	}
	
	//需求1:算阶乘 n!
	public static int method3(int n) {
		if(n==1){
			return 1;
		}else {
			return n*method3(n-1);		//5*4*3*2*1			5*4*……*1
				//5*method3(4)--->5*4*method3(3)--->5*4*3*method3(2)--->5*4*3*2*method3(1)--->5*4*3*2*1
		}
	}

}
