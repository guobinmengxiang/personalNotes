package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 字符流
 * Reader字符输入流 
 * Writer字符输出流 
 * 专门用于字符的形式读取和写入数据
 * 这个东西是一个个读取的，不适用与一行行读取，
 * 写的时候，没特殊要求是写到一行的
 */
public class Stream2 {

	 public static void main(String[] args) {
		
		// write();
		 read();
}

public static void read(){
	 File f = new File("D:/ceshi/2.txt");
	 try(FileReader fi=new FileReader(f)) {
		 char [] all = new char[(int)f.length()];
		 fi.read(all);
		 for(char a :all){
			 System.out.print(a);
		 }
		
	} catch (Exception e) {
		// TODO: handle exception
	}
}

public static void write(){
	 File f = new File("D:/ceshi/3.txt");
	 try(FileWriter fi=new FileWriter(f)) {
		 File dir =f.getParentFile();
		 if(dir.exists()){
			 dir.mkdirs();
		 }
		 char [] all = new char[(int)f.length()];
	     String data="张国彬";
	     //将字符串转换为字符数组
         char[] cs = data.toCharArray();
         fi.write(cs);
		
	} catch (Exception e) {
		// TODO: handle exception
	}
}
}

