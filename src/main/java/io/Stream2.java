package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author �ַ���
 * Reader�ַ������� 
 * Writer�ַ������ 
 * ר�������ַ�����ʽ��ȡ��д������
 * ���������һ������ȡ�ģ���������һ���ж�ȡ��
 * д��ʱ��û����Ҫ����д��һ�е�
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
	     String data="�Ź���";
	     //���ַ���ת��Ϊ�ַ�����
         char[] cs = data.toCharArray();
         fi.write(cs);
		
	} catch (Exception e) {
		// TODO: handle exception
	}
}
}

