package Multithreading;
/**
 * @author 对象监视器 synchronized(obj)
 *锁住非 this 对象有很大的优点，如果一个类中含有多个 synchronized 方法，这时候虽然能够实现同步，
 *但是会受到阻塞，所以影响运行效率，但如果使用同步代码块锁住非 this 对象的话，synchronized(obj) 
 *代码块中的程序与同步方法是异步的，不与其他锁 this 同步方法争抢 this 锁，
 *则可以大大提高线程的执行效率，最终可以达到方法内，一半同步，一半异步等多种结合模式
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
//线程1死循环，导致线程2阻塞
/*class Myserver6{
	synchronized public void metha(){
		System.out.println("死循环开始");
		Boolean flag = true;
		while(flag){}
		System.out.println("死循环结束");
	}
	
	synchronized public void methb(){
		System.out.println("b开始");
		System.out.println("b结束");
	}
	  
}*/
//如果改成如下，通过同步块来解决无限等待问题
class Myserver6{
	private Object obj = new Object();
	 public void metha(){
		 synchronized(obj){
		System.out.println("死循环开始");
		Boolean flag = true;
		while(flag){}
		System.out.println("死循环结束");
		 }
	}
	
	synchronized public void methb(){
		System.out.println("b开始");
		System.out.println("b结束");
	}
	  
}
