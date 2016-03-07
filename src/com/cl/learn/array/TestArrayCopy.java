package com.cl.learn.array;

public class TestArrayCopy {
	public static void main(String[] args) {
		int[] a={1,2,3};
		int[] b={4,5,6};
		System.arraycopy(a, 1, b, 1, 2);
		for(int i=0;i<b.length;i++){
			System.out.println(b[i]);
		}
	}
}