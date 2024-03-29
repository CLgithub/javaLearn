package com.cl.javabasis.day3;

/*
位运算符：位运算符就是直接操作二进制位的。
	& (与)
	| (或)
	^ (异或):相同为0，相异为1
		规律： 如果操作数A连续异或同一个操作数两次，那么结果还是操作数A。(其实是任何数A与0异或都为A，异或运算可以使用结合律)
		应用： 对数据加密.
	~  (取反)
*/
class Demo09{

	public static void main(String[] args){
		System.out.println(6&3); // 2 = 110 & 011 = 010
		System.out.println(6|3); // 7 = 100 | 011 = 111
		System.out.println(6^3^3); //  6	= 110 ^ 011 ^ 011	= 110 ^ 000 = 110

		System.out.println(~7);  // -8   0111 取反 1000 
		System.out.println(~-7);	//  以 1111(-1) 和 0000(0) 为分界线 所以-7取反，就是取分界线的另一边，所以是6
	}
}

