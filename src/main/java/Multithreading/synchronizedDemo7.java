package Multithreading;

import java.util.ArrayList;
import java.util.List;


/**
 * @author  wait 等待，通知 notify
 *wait() 函数在没有锁的情况下将会触发 IllegalMonitorStateException 异常
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
		list.add("张国彬");
		
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
            System.out.println("wait 开始" + System.currentTimeMillis());
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wait 结束" + System.currentTimeMillis());
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
            System.out.println("已添加"+i+"个元素");
            if (Somethom.size() == 5) {
                lock.notify();
                System.out.println("已唤醒");
            }
        }
    }
}
}
