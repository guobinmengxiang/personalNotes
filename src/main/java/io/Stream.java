package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author �ֽ����������ֽ������
 *�������ֽڵ���ʽ��ȡ��д������
 *����д����д���ļ�
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
		File f = new File("D:/ceshi/2.txt");
		// //����������try()��,try,catch����finally������ʱ�򣬻��Զ��ر�v
		//���ֱ�д����ķ�ʽ���� try-with-resources�� ���Ǵ�JDK7��ʼ֧�ֵļ���
		try(FileOutputStream fs=new FileOutputStream(f)){
		     //���Ȼ�ȡ�ļ����ڵ�Ŀ¼
            File dir = f.getParentFile();
            //�����Ŀ¼�����ڣ��򴴽���Ŀ¼
            if(!dir.exists()){
//              dir.mkdir(); //ʹ��mkdir���׳��쳣����Ϊ��Ŀ¼�ĸ�Ŀ¼Ҳ������
                dir.mkdirs(); //ʹ��mkdirs���Ѳ����ڵ�Ŀ¼��������
            }
			byte date [] = {88,89};
			//���������ļ��������
			
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
