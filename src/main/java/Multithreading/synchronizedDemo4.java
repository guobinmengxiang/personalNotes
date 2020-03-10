package Multithreading;
/**
 * @author ʵ�������� synchronized(this)
 *�����������̷߳���ͬһ������ object �е�synchronized(this)ͬ�������ʱ��һ��ʱ����ֻ����һ���̱߳�ִ�У�
 *����һ���̱߳���ȴ���ǰ�߳�ִ�������������Ժ󣬲���ִ�иô���顣
 *���¼���ʵ��֤������ synchronized ������еĴ�������첽ִ�еģ����� synchronized ������о���ͬ��ִ�еġ�
 */
public class synchronizedDemo4{
    public static void main(String[] args){
    	Myserver me= new Myserver();
    	Thread a = new syDemoA4(me);
    	a.setName("a");
    	a.start();
    	Thread b =new synDemoB4(me);
    	b.setName("b");
    	b.start();
    	
     } 
}

class syDemoA4 extends Thread{
	private Myserver myserver;
	public syDemoA4(Myserver myserver){
		super();
		this.myserver=myserver;
	}
	
	
public void run(){
	super.run();
	myserver.myMethod();
}
}

class synDemoB4 extends Thread{
	private Myserver myserver;
	public synDemoB4(Myserver myserver){
		super();
		this.myserver=myserver;
	}
	public void run(){
		super.run();
		myserver.myMethod();
	}
}
//����ͬ��ִ�з���
/*class Myserver {
	public void myMethod(){
        try{
            synchronized (this){
                System.out.println("begin time :" + System.currentTimeMillis());
                Thread.sleep(1000);
                System.out.println("end time :" + System.currentTimeMillis());
            }
        }catch(InterruptedException exception){
            exception.printStackTrace();
        }
    }
}
*/
//�����첽ִ�з���
/*class Myserver {
    private String getData1;
    private String getData2;
    public void myMethod() {
        System.out.println("��ʼ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String privateGetData1 = "��������󷵻�ֵ1��threadName" + Thread.currentThread();
        String privateGetData2 = "��������󷵻�ֵ2��threadName" + Thread.currentThread();

        synchronized(this) {
            getData1 = privateGetData1;
            getData2 = privateGetData2;
        }
        System.out.println(getData1);
        System.out.println(getData2);
        System.out.println("����");
    }
}*/
class Myserver{
    public void myMethod() {
        for (int i = 0; i < 10; i++) {
            System.out.println("û��synchronized(this)�Ĵ���" + Thread.currentThread().getName() + ",i:" + i);
        }
        System.out.println("");
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println("��synchronized(this)�Ĵ���"+Thread.currentThread().getName()+",i:"+i);
            }
        }
    }
}
