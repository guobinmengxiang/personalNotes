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
 * @author ������ �����ַ������� BufferedReader ����һ�ζ�ȡһ������
 * PrintWriter �����ַ�������� ����һ��д��һ������
 * �и����⣬�������ǵȻ�������֮��Ż��ύд����������������Ҫ����д����ô�죬���ż���������pw.flush();
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
		// �����ļ��ַ���
		// ���������뽨����һ�����ڵ����Ļ�����
		try (FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				FileWriter fw = new FileWriter(f1);
				PrintWriter pw = new PrintWriter(fw);) {

			while (true) {
				//һ���еĻ�ȡ�������ĳһ��Ϊ�յ�ʱ��˵�������ˣ����˳�ѭ��
				String line = br.readLine();
				if (line == null) {
					break;
				}
				//һ���е�ȥд�����ݣ������print,��д�뵽һ�У�
				pw.println(line);
				//�����ύ�������ǵȻ����������ύ
				//pw.flush();
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
