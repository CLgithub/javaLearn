package com.cl.learn.iotest.bytestream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStream {

	public static void main(String[] args) {
		try {
			Sender sender = new Sender();
			Receiver receiver = new Receiver();
			PipedOutputStream pOutputStream = sender.getPipedOutputStream();
			PipedInputStream pInputStream = receiver.getPipedInputStream();
//			pOutputStream.connect(pInputStream);
			pInputStream.connect(pOutputStream);
			receiver.start();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			new Thread(sender).start();
		} catch (IOException e) {
 			e.printStackTrace();
		}
	}
	
	/**
	 * 测试PipedOutputStream，主要用于线程间通信
	 * @author L
	 * @date 2016年2月19日
	 */
	static class Sender implements Runnable{
		private PipedOutputStream pipedOutputStream=new PipedOutputStream();
		public PipedOutputStream getPipedOutputStream() {
			return pipedOutputStream;
		}

		public void run() {
			String str="test 1561851 中文测试";
			try {
				pipedOutputStream.write(str.getBytes());
				pipedOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 测试PipedInputStream，主要用于线程间通信
	 * @author L
	 * @date 2016年2月19日
	 */
	static class Receiver extends Thread{
		private PipedInputStream pipedInputStream=new PipedInputStream();
		public PipedInputStream getPipedInputStream() {
			return pipedInputStream;
		}
		public void run() {
			try {
				byte[] bytes=new byte[1024];
				int len=pipedInputStream.read(bytes);
				System.out.println(new String(bytes,0,len));
				pipedInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
