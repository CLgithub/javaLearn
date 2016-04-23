package com.cl.javabasis.day23demo3;

public class ChatMain {
	public static void main(String[] args) {
		new Thread(new ChatReceive()).start();
		new Thread(new ChatSender()).start();
	}
}
