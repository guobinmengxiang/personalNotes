package Multithreading;
/**
 * @author ��������� synchronized(obj)
 *��ס�� this �����кܴ���ŵ㣬���һ�����к��ж�� synchronized ��������ʱ����Ȼ�ܹ�ʵ��ͬ����
 *���ǻ��ܵ�����������Ӱ������Ч�ʣ������ʹ��ͬ���������ס�� this ����Ļ���synchronized(obj) 
 *������еĳ�����ͬ���������첽�ģ����������� this ͬ���������� this ����
 *����Դ������̵߳�ִ��Ч�ʣ����տ��Դﵽ�����ڣ�һ��ͬ����һ���첽�ȶ��ֽ��ģʽ
 */
public class synchronizedDemo6{
    public static void main(String[] args){
    	Myserver6 myService = new Myserver6();
          Thread a = new syDemoA6(myService);
          a.start();
          Thread b = new synDemoB6(myService);
          b.start();
     } 
}

class syDemoA6 extends Thread{
	private Myserver6 myserver;
	public syDemoA6(Myserver6 myserver){
		super();
		this.myserver=myserver;
	}
	
	
public void run(){
	super.run();
	myserver.metha();
}
}

class synDemoB6 extends Thread{
	private Myserver6 myserver;
	public synDemoB6(Myserver6 myserver){
		super();
		this.myserver=myserver;
	}
	public void run(){
		super.run();
		myserver.methb();
	}
}
//�߳�1��ѭ���������߳�2����
/*class Myserver6{
	synchronized public void metha(){
		System.out.println("��ѭ����ʼ");
		Boolean flag = true;
		while(flag){}
		System.out.println("��ѭ������");
	}
	
	synchronized public void methb(){
		System.out.println("b��ʼ");
		System.out.println("b����");
	}
	  
}*/
//����ĳ����£�ͨ��ͬ������������޵ȴ�����
class Myserver6{
	private Object obj = new Object();
	 public void metha(){
		 synchronized(obj){
		System.out.println("��ѭ����ʼ");
		Boolean flag = true;
		while(flag){}
		System.out.println("��ѭ������");
		 }
	}
	
	synchronized public void methb(){
		System.out.println("b��ʼ");
		System.out.println("b����");
	}
	  
}
