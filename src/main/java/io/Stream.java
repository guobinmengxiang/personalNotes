package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author �ֽ����������ֽ������
 *�������ֽڵ���ʽ��ȡ��д������
 */
public class Stream {

	public static void main(String[] args) {
	//write();
	read();
	}
	
	/**
	 * �����
	 */
	public static void write(){
		try{
			File f = new File("D:/ceshi/2.txt");
			byte date [] = {88,89};
			//���������ļ��������
			FileOutputStream fs=new FileOutputStream(f);
			//������д�������
			fs.write(date);
			//�ر���
			fs.close();
		}catch(IOException e){
			e.printStackTrace();
			
		}

	}
	
	/**
	 * ������
	 */
	public static void read(){
		try{
			File f = new File("D:/ceshi/2.txt");
			//���������ļ�����ru��
			FileInputStream fs=new FileInputStream(f);
			//�����ļ����ȵ�����
			byte a [] =new byte [(int) f.length()];
			//������д�������
			fs.read(a);
			for(byte as :a){
				System.out.println(as);
			}
			//�ر���
			fs.close();
		}catch(IOException e){
			e.printStackTrace();
			
		}

	}
	

}
