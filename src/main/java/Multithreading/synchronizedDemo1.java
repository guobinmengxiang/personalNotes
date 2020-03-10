package Multithreading;
/**
 * @author 实例变量是线程不安全的，方法内的变量是线程安全的；
 *多个线程需要创建多个ReturnSomething，因为多个线程需要多把锁，如果多个线程公用一把锁，则是同步的，而非异步
 */
public class synchronizedDemo1{
    public static void main(String[] args){
    	//实例化返参类
        ReturnSomething returnSomething = new ReturnSomething();
        for(int i=0;i<2000;i++){
        	//创建2000个线程
            Thread a = new ThreadA1(returnSomething);
            a.start();
            Thread b = new ThreadB(returnSomething);
            b.start();
        }
    }
}

class ReturnSomething{
	//实例变量为非线程安全的，方法内变量是线程安全的
    int i = 0;
    /**
     * @param 此时如果不加synchronized的话，是非线程安全的
     * @return
     */
    synchronized  public int get(String a){
        if(a.equals("abc")){
            i = 500;
        }else{
            i = 10;
        }
        return i;
    }
}

class ThreadA1 extends Thread{
    private ReturnSomething returnSomething;
    public ThreadA1(ReturnSomething returnSomething){
    	//继承无参构造方法
        super();
        this.returnSomething = returnSomething;
    }
    @Override
    public void run(){
        int a = returnSomething.get("abc");
        if(a == 10){
            System.out.println("a=10, 线程安全出现问题。");
        }
    }
}

class ThreadB extends Thread{
    private ReturnSomething returnSomething;
    public ThreadB(ReturnSomething returnSomething){
        super();
        this.returnSomething = returnSomething;
    }
    @Override
    public void run(){
        super.run();
        int b = returnSomething.get("def");
        if(b == 500){
            System.out.println("b=500, 线程安全出现问题。");
        }
    }
}

