package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 缓存流 缓存字符输入流 BufferedReader 可以一次读取一行数据
 * PrintWriter 缓存字符输出流， 可以一次写出一行数据
 * 有个问题，缓存流是等缓存满了之后才会提交写入操作，但是如果需要立即写入怎么办，别着急，可以用pw.flush();
 */
public class Stream3 {
	public static void main(String[] args) {
		read();
	}

	public static void read() {
		File f = new File("d://ceshi/3.txt");
		File f1 = new File("d://ceshi/4.txt");
		File dir = f1.getParentFile();
		if (!dir.exists()) {
			dir.mkdirs();
		}
		// 创建文件字符流
		// 缓存流必须建立在一个存在的流的基础上
		try (FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				FileWriter fw = new FileWriter(f1);
				PrintWriter pw = new PrintWriter(fw);) {

			while (true) {
				//一行行的获取，如果当某一行为空的时候，说明到底了，就退出循环
				String line = br.readLine();
				if (line == null) {
					break;
				}
				//一行行的去写入数据，如果用print,是写入到一行；
				pw.println(line);
				//立马提交，而不是等缓存满了在提交
				//pw.flush();
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
