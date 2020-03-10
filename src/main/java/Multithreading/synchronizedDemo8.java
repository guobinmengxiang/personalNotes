package Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



/**
 * @author join() 的作用是等待线程销毁。
 *  a.join(); 代表主线程等a线程执行完之后销毁之后，在执行
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
	        System.out.println("这句话应该等 run end 结束之后再输出");
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




