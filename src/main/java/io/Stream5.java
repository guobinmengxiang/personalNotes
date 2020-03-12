package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author ������ָ���ǿ���ֱ�Ӱ�һ��������������ʽ����������Ľ��ʣ�����Ӳ�� һ��������������ʽ���д��䣬�������л���
 *         �ö�������Ӧ���࣬������ʵ��Serializable�ӿ� ��ʵ�������л��ͷ����л���
 *         ʲô�������л����ͷ����л���һ������תΪ�ֽ����еĹ��̾ͽ������л�����֮������
 *         ʲô�������õ�������߲�������session,����10���û�����10��session����ʱ���ڴ���е�Բ����ˣ���ô�͵����л���Ӳ�̣���ͷ�õ�ʱ���ڷ����л�
 */
public class Stream5 {

	public static void main(String[] args) {
		Hero h = new Hero();
		h.name = "�Ź���";
		h.hp = 111;
		File f = new File("d://ceshi/garen.lol");
		File dir = f.getParentFile();
		if (!dir.exists()) {
			dir.mkdirs();
		}
		try (
				// �������������
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				// ��������������
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			oos.writeObject(h);
			Hero h2 = (Hero) ois.readObject();
			System.out.println(h2.name);
			System.out.println(h2.hp);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
