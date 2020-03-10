package Multithreading;
/**
 * @author 对象监视器 synchronized(obj)
 *锁住非 this 对象有很大的优点，如果一个类中含有多个 synchronized 方法，这时候虽然能够实现同步，
 *但是会受到阻塞，所以影响运行效率，但如果使用同步代码块锁住非 this 对象的话，synchronized(obj) 
 *代码块中的程序与同步方法是异步的，不与其他锁 this 同步方法争抢 this 锁，
 *则可以大大提高线程的执行效率，最终可以达到方法内，一半同步，一半异步等多种结合模式
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
	// 看到上面实例化的对象没，如果在方法体外面，则多线程是同步的，如果放在下面则是异步的
	//在 synchronized(obj) 想锁住对象的最关键因素也在于，必须是同一个 obj 对象，如果两段线程 new 出了两个 obj 对象的情况下，是达不到对象监视器的作用的
	    public void setUsernameAndPassword(String username,String password) {
	    String something = new String();

	        synchronized(something) {
	            System.out.println("线程名称为：" + Thread.currentThread().getName()
	                    + "在" + System.currentTimeMillis() + "时间进入同步模块");
	            this.username = username;
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            this.password = password;
	            System.out.println("线程名称为：" + Thread.currentThread().getName()
	                    + "在" + System.currentTimeMillis() + "时间离开同步模块");
	        }
	    }
}
