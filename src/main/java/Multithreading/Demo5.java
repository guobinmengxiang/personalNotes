package Multithreading;

/**
 * @author ��synchronized ���ʵ������İ�ȫ����
 * synchronized ������������󼰷����ϼ���������������δ��뱻��֮Ϊ�������������ٽ���
 *����30���̣߳����synchronizedȥ������ᷢ��������û����
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

