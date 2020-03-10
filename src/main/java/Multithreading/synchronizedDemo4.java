package Multithreading;
/**
 * @author 实例对象锁 synchronized(this)
 *当两个并发线程访问同一个对象 object 中的synchronized(this)同步代码块时，一段时间内只能有一个线程被执行，
 *而另一个线程必须等待当前线程执行完这个代码块以后，才能执行该代码块。
 *以下几个实验证明不在 synchronized 代码块中的代码就是异步执行的，而在 synchronized 代码块中就是同步执行的。
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
//整体同步执行方法
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
//部分异步执行方法
/*class Myserver {
    private String getData1;
    private String getData2;
    public void myMethod() {
        System.out.println("开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String privateGetData1 = "处理任务后返回值1：threadName" + Thread.currentThread();
        String privateGetData2 = "处理任务后返回值2：threadName" + Thread.currentThread();

        synchronized(this) {
            getData1 = privateGetData1;
            getData2 = privateGetData2;
        }
        System.out.println(getData1);
        System.out.println(getData2);
        System.out.println("结束");
    }
}*/
class Myserver{
    public void myMethod() {
        for (int i = 0; i < 10; i++) {
            System.out.println("没有synchronized(this)的代码" + Thread.currentThread().getName() + ",i:" + i);
        }
        System.out.println("");
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println("有synchronized(this)的代码"+Thread.currentThread().getName()+",i:"+i);
            }
        }
    }
}
