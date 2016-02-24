package com.cl.learn.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList arrayList=new ArrayList<>();
		int b=0;
		while(true){
			try {
				b=System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(b!='\n'&&b!='\r'){
				arrayList.add(new Integer(b-'0'));//b是ascii，减去字符'0'的ascii码
			}else {
				int sun=0;
				Iterator iterator=arrayList.iterator();
				while(iterator.hasNext()){
					Integer integer=(Integer) iterator.next();
					sun+=integer.intValue();
				}
				System.out.println(sun);
				arrayList=new ArrayList<>();
			}
		}
		
	}
}
