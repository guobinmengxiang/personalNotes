package Multithreading;

import java.util.ArrayList;
import java.util.List;


/**
 * @author  wait �ȴ���֪ͨ notify
 *wait() ������û����������½��ᴥ�� IllegalMonitorStateException �쳣
 */
public class synchronizedDemo7{
	 public static void main(String[] args) {
		 Somethom something = new Somethom();
	        Thread a = new ThreadDemoA7(something);
	        a.setName("A");
	        a.start();

	        Thread b = new ThreadDemoB7(something);
	        b.setName("B");
	        b.start();
	 }
}

class Somethom{
	private static List<String> list = new ArrayList<>();
	static public void add(){
		list.add("�Ź���");
		
	}
	static  public int  size(){
		return list.size();
	}
}
class ThreadDemoA7 extends Thread{
	private Object lock;
public ThreadDemoA7(Object lock){
	super();
	this.lock=lock;
}
public void run() {
    synchronized (lock) {
        if (Somethom.size() != 5) {
            System.out.println("wait ��ʼ" + System.currentTimeMillis());
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wait ����" + System.currentTimeMillis());
        }
    }
}
}
class ThreadDemoB7 extends Thread{
	private Object lock;
public ThreadDemoB7(Object lock){
	super();
	this.lock=lock;
}
public void run() {
    synchronized (lock) {
        for (int i = 0; i < 10; i++) {
        	Somethom.add();
            System.out.println("�����"+i+"��Ԫ��");
            if (Somethom.size() == 5) {
                lock.notify();
                System.out.println("�ѻ���");
            }
        }
    }
}
}
