package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author 对象流指的是可以直接把一个对象以流的形式传输给其他的介质，比如硬盘 一个对象以流的形式进行传输，叫做序列化。
 *         该对象所对应的类，必须是实现Serializable接口 其实就是序列化和反序列化，
 *         什么叫做序列化，和反序列化，一个对象转为字节序列的过程就叫做序列化，反之。。。
 *         什么场景会用到，比如高并发，存session,比如10万用户就是10万session，这时候内存就有点吃不消了，那么就得序列化放硬盘，回头用的时候在反序列化
 */
public class Stream5 {

	public static void main(String[] args) {
		Hero h = new Hero();
		h.name = "张国彬";
		h.hp = 111;
		File f = new File("d://ceshi/garen.lol");
		File dir = f.getParentFile();
		if (!dir.exists()) {
			dir.mkdirs();
		}
		try (
				// 创建对象输出流
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				// 创建对象输入流
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
