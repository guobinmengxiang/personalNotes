package Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



/**
 * @author join() �������ǵȴ��߳����١�
 *  a.join(); �������̵߳�a�߳�ִ����֮������֮����ִ��
 */
public class synchronizedDemo8{
	 public static void main(String[] args) {
		 Thread a = new ThreadA8();
	        a.start();
	        try {
	           a.join();
	  
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        System.out.println("��仰Ӧ�õ� run end ����֮�������");
	    }
}


class ThreadA8 extends Thread{

    @Override
    public void run() {
        super.run();
        try {
            System.out.println("ThreadA run start");
            Thread.sleep(new Random().nextInt(3000));
            System.out.println("ThreadA run end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}




