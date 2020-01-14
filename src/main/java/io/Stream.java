package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 字节输入流、字节输出流
 *用于以字节的形式读取和写入数据
 */
public class Stream {

	public static void main(String[] args) {
	//write();
	read();
	}
	
	/**
	 * 输出流
	 */
	public static void write(){
		try{
			File f = new File("D:/ceshi/2.txt");
			byte date [] = {88,89};
			//创建基于文件的输出流
			FileOutputStream fs=new FileOutputStream(f);
			//把数据写入输出流
			fs.write(date);
			//关闭流
			fs.close();
		}catch(IOException e){
			e.printStackTrace();
			
		}

	}
	
	/**
	 * 输入流
	 */
	public static void read(){
		try{
			File f = new File("D:/ceshi/2.txt");
			//创建基于文件的输ru流
			FileInputStream fs=new FileInputStream(f);
			//创建文件长度的数组
			byte a [] =new byte [(int) f.length()];
			//把数据写入输出流
			fs.read(a);
			for(byte as :a){
				System.out.println(as);
			}
			//关闭流
			fs.close();
		}catch(IOException e){
			e.printStackTrace();
			
		}

	}
	

}
