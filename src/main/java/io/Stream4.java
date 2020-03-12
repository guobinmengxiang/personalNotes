package io;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author������
 * DataInputStream ���������� 
 *DataOutputStream ���������
 *Ҫ��DataInputStream ��ȡһ���ļ�������ļ���������DataOutputStream д���ģ���������EOFException����ΪDataOutputStream ��д����ʱ�����һЩ�����ǣ�ֻ��DataInputStream ���ܳɹ��Ķ�ȡ��
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
			ds.writeUTF("�����Ź���");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	

}
