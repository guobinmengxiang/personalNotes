package Multithreading;

/**
 * @authorֹͣ�߳�
 * ʹ�� interrupt() ����ֹͣ��ǰ�߳�
 *interrupted() ���Ե�ǰ�߳��Ƿ����ж�
 *isInterrupted()���Դ��߳��Ƿ����жϡ�
 *interrupted() ֻ��ֹͣ���̣߳����޷�ֹͣ���̣߳���Ϊ interrupted() ������Ҫ���һ��ֹͣ�̵߳�λ�ã�Ȼ��Ż�ֹͣ�߳�
 *����ʹ��interrupt()����ֹͣ���̡߳����쳣�ķ�ʽֹͣ���߳� ���������Ƽ��������쳣�ķ�ʽֹͣ���߳�
 */
public class Demo7 {

	public static void main(String[] args){

        Thread myThread = new MyThread1();
        System.out.println("��ʼ��" + myThread.isAlive());
        myThread.start();
        System.out.println("������" + myThread.isAlive());
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
        System.out.println("������" + myThread.isAlive());
    }
}
class MyThread1 extends Thread{
    @Override
    public void run(){
        while(true){}
    }
    
    //���쳣�ķ�ʽֹͣ���߳�
  /*  public void run(){
        try{
            while(true){
                if(this.interrupted()){
                    System.out.println("isInterrupted:" + this.isInterrupted());
                    throw new InterruptedException();
                }
                System.out.println("�������");
            }
        } catch(InterruptedException exception){
            System.out.println("�����쳣");
        }*/
}


