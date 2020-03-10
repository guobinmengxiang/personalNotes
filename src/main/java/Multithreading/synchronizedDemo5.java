package Multithreading;
/**
 * @author ��������� synchronized(obj)
 *��ס�� this �����кܴ���ŵ㣬���һ�����к��ж�� synchronized ��������ʱ����Ȼ�ܹ�ʵ��ͬ����
 *���ǻ��ܵ�����������Ӱ������Ч�ʣ������ʹ��ͬ���������ס�� this ����Ļ���synchronized(obj) 
 *������еĳ�����ͬ���������첽�ģ����������� this ͬ���������� this ����
 *����Դ������̵߳�ִ��Ч�ʣ����տ��Դﵽ�����ڣ�һ��ͬ����һ���첽�ȶ��ֽ��ģʽ
 */
public class synchronizedDemo5{
    public static void main(String[] args){
    	Myserver5 myService = new Myserver5();
          Thread a = new syDemoA5(myService);
          a.setName("at");
          a.start();
          Thread b = new synDemoB5(myService);
          b.setName("bt");
          b.start();
     } 
}

class syDemoA5 extends Thread{
	private Myserver5 myserver;
	public syDemoA5(Myserver5 myserver){
		super();
		this.myserver=myserver;
	}
	
	
public void run(){
	super.run();
	myserver.setUsernameAndPassword("a", "a");
}
}

class synDemoB5 extends Thread{
	private Myserver5 myserver;
	public synDemoB5(Myserver5 myserver){
		super();
		this.myserver=myserver;
	}
	public void run(){
		super.run();
		myserver.setUsernameAndPassword("b", "b");
	}
}

class Myserver5{
	 private String username;
	    private String password;
	//    private String something = new String();
	// ��������ʵ�����Ķ���û������ڷ��������棬����߳���ͬ���ģ�����������������첽��
	//�� synchronized(obj) ����ס�������ؼ�����Ҳ���ڣ�������ͬһ�� obj ������������߳� new �������� obj ���������£��Ǵﲻ����������������õ�
	    public void setUsernameAndPassword(String username,String password) {
	    String something = new String();

	        synchronized(something) {
	            System.out.println("�߳�����Ϊ��" + Thread.currentThread().getName()
	                    + "��" + System.currentTimeMillis() + "ʱ�����ͬ��ģ��");
	            this.username = username;
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            this.password = password;
	            System.out.println("�߳�����Ϊ��" + Thread.currentThread().getName()
	                    + "��" + System.currentTimeMillis() + "ʱ���뿪ͬ��ģ��");
	        }
	    }
}
