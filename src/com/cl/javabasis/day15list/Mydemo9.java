package com.cl.javabasis.day15list;

import java.util.LinkedList;
import java.util.Random;

/**
 * 需求：使用LinkedLis存储一副扑克牌，然后实现洗牌功能
 * 
 * 自定义一个
 */
public class Mydemo9 {
	public static void main(String[] args) {
		LinkedList list = LoadP();
//		System.out.println(list);
//		System.out.println(list.size());
		showPoker(list);
		shufflePoker(list);
		System.out.println("");
		showPoker(list);
	}
	
	//洗牌
	private static void shufflePoker(LinkedList list) {
		Random random=new Random();
		for(int i=0;i<300;i++){
			int x=random.nextInt(list.size());
			int x2=random.nextInt(list.size());
			Poker tmp=(Poker) list.get(x);
			list.set(x, list.get(x2));
			list.set(x2, tmp);
		}
	}

	//显示扑克牌
	private static void showPoker(LinkedList list){
		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i));
			if((i+1)%10==0){
				System.out.println();
			}
		}
	}
	
	private static LinkedList LoadP() {
		LinkedList list=new LinkedList();
		String[] types={"红桃","黑桃","方片","梅花"};
		String[] varlus={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		for(int i=0;i<varlus.length;i++){
			for(int j=0;j<types.length;j++){
				list.add(new Poker(types[j], varlus[i]));
			}
		}
		return list;
	}
}

class Poker{
	String type;
	String value;

	public Poker(String type, String value) {
		this.type = type;
		this.value = value;
	}

	public String toString() {
		return "[" + type + value + "]";
	}
	
}
