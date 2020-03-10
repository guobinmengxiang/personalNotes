package Multithreading;

/**
 * @author 用synchronized 解决实例共享的安全问题
 * synchronized 可以在任意对象及方法上加锁，而加锁的这段代码被称之为“互斥区”或“临界区
 *创建30个线程，你把synchronized去掉，你会发现这数据没法看
 */
public class Demo5 {

	public static void main(String[] args) {
		Thread testThread = new testThread();
	     for(int i=0;i<30;i++){
	    	 Thread tr= new Thread(testThread);
	    	 tr.start();
	     }
	}

}

class testThread extends Thread{
	int count=50;
	synchronized public void run(){
		System.out.println("count"+count);
		count--;
	}
}

