package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 字节输入流、字节输出流
 *用于以字节的形式读取和写入数据
 *用于写出、写入文件
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
		File f = new File("D:/ceshi/2.txt");
		// //把流定义在try()里,try,catch或者finally结束的时候，会自动关闭v
		//这种编写代码的方式叫做 try-with-resources， 这是从JDK7开始支持的技术
		try(FileOutputStream fs=new FileOutputStream(f)){
		     //首先获取文件所在的目录
            File dir = f.getParentFile();
            //如果该目录不存在，则创建该目录
            if(!dir.exists()){
//              dir.mkdir(); //使用mkdir会抛出异常，因为该目录的父目录也不存在
                dir.mkdirs(); //使用mkdirs则会把不存在的目录都创建好
            }
			byte date [] = {88,89};
			//创建基于文件的输出流
			
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
