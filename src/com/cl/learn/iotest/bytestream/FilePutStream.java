package com.cl.learn.iotest.bytestream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class FilePutStream {

	public static void main(String[] args) {
		File file = new File("e:/filePutStreamTest.txt");
//		testFilePutStream(file);
		testFRFW(file);
	}

	/**
	 * 测试FileOutputStream和FileInputStream对文件操作
	 * @author L
	 * @date 2016年2月19日
	 * @param file 文件对象
	 */
	private static void testFilePutStream(File file) {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			String str = "test FilePutStream 123456131 中文测试";
			fos.write(str.getBytes());
			fos.close();//没有缓冲区，close后立刻会写入到磁盘
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			FileInputStream fis = new FileInputStream(file);
			System.out.println(file.length());
			byte[] b = new byte[(int) file.length()];
			int len = fis.read(b);
			System.out.println(new String(b, 0, len));
			System.out.println(b);

			fis.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 测试FileReader和FileWriter对文件操作，这两个包装类可方便对读写文件
	 * @author L
	 * @date 2016年2月19日
	 * @param file
	 */
	private static void testFRFW(File file) {
		try {
			FileWriter fWriter = new FileWriter(file);
			String str = "testFRFW 12345605  中文";
			fWriter.write(str);
//			fWriter.flush();//有缓存区，要flush或close才会写入磁盘
			fWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FileReader fReader=new FileReader(file);
			char[] chars=new char[1024];
			int len=fReader.read(chars);
			System.out.println(new String(chars,0,len));
			
			fReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
