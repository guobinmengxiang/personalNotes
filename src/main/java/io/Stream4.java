package io;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author数据流
 * DataInputStream 数据输入流 
 *DataOutputStream 数据输出流
 *要用DataInputStream 读取一个文件，这个文件必须是由DataOutputStream 写出的，否则会出现EOFException，因为DataOutputStream 在写出的时候会做一些特殊标记，只有DataInputStream 才能成功的读取。
 */
public class Stream4 {

	public static void main(String[] args) {
		write();
		read();

	}
	
	public static void read(){
		File f = new File("D://ceshi/5.txt");
		try(FileInputStream fs = new FileInputStream(f);
			DataInputStream ds = new DataInputStream(fs);) {
			 	
			Boolean a = ds.readBoolean();
			int i = ds.readInt();
			String aa=ds.readUTF();
			System.out.println("boolean"+a);
			System.out.println("int"+i);
			System.out.println("String"+aa);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void write(){
		File f = new File("D://ceshi/5.txt");
		File dir=f.getParentFile();
		if(!dir.exists()){
			dir.mkdirs();
		}
		try(FileOutputStream fs = new FileOutputStream(f); 
			DataOutputStream ds = new DataOutputStream(fs);){
			
			ds.writeBoolean(true);
            ds.writeInt(300);
			ds.writeUTF("我是张国彬啊");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	

}
