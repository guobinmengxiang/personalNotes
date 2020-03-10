package Multithreading;

/**
 * @author停止线程
 * 使用 interrupt() 方法停止当前线程
 *interrupted() 测试当前线程是否已中断
 *isInterrupted()测试此线程是否已中断。
 *interrupted() 只能停止主线程，而无法停止多线程，因为 interrupted() 首先需要标记一个停止线程的位置，然后才会停止线程
 *可以使用interrupt()方法停止多线程、用异常的方式停止多线程 ，其中最推荐的是用异常的方式停止多线程
 */
public class Demo7 {

	public static void main(String[] args){

        Thread myThread = new MyThread1();
        System.out.println("开始：" + myThread.isAlive());
        myThread.start();
        System.out.println("结束：" + myThread.isAlive());
        try{
            Thread.sleep(1000);
        } catch(Exception exception){
            exception.printStackTrace();
        }
        System.out.println("isInterrupted1:" + myThread.isInterrupted());
        myThread.interrupt();
        System.out.println("isInterrupted2:" + myThread.isInterrupted());
        myThread.interrupted();
        System.out.println("isInterrupted3:" + myThread.isInterrupted());
        myThread.interrupted();
        System.out.println("isInterrupted4:" + myThread.isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println("isInterrupted5:" + myThread.isInterrupted());
        Thread.interrupted();
        System.out.println("isInterrupted6:" + myThread.isInterrupted());
        System.out.println("结束后：" + myThread.isAlive());
    }
}
class MyThread1 extends Thread{
    @Override
    public void run(){
        while(true){}
    }
    
    //用异常的方式停止多线程
  /*  public void run(){
        try{
            while(true){
                if(this.interrupted()){
                    System.out.println("isInterrupted:" + this.isInterrupted());
                    throw new InterruptedException();
                }
                System.out.println("不会输出");
            }
        } catch(InterruptedException exception){
            System.out.println("进入异常");
        }*/
}


