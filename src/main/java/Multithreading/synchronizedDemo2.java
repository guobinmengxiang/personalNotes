package Multithreading;
/**
 * @author 多个实例多把锁
 * 一把锁的话是同步，多把锁是异步
 *
 */
public class synchronizedDemo2{
	 public static void main(String[] args){
		// synDeom2 sya = new synDeom2();
		 synDeom2 syb = new synDeom2();
	        Thread ta = new ThreadAdemo2(syb);
	        ta.start();
	        Thread tb = new ThreadBdemo2(syb);
	        tb.start();
	    }
    
}

class ThreadAdemo2 extends Thread {
	private synDeom2 sy;
    public ThreadAdemo2(synDeom2 sy){
        super();
        this.sy = sy;
    }
    @Override
    public void run(){
        int a = sy.get("abc");
        System.out.println("int a=" + a);
        if(a == 10){
            System.out.println("a=10, 线程安全出现问题。");
        }
    }
}

class ThreadBdemo2 extends Thread {
	
	private synDeom2 sy;
    public ThreadBdemo2(synDeom2 sy){
        super();
        this.sy = sy;
    }
    @Override
    public void run(){
        super.run();
        int b = sy.get("def");
        System.out.println("int b=" + b);
        if(b == 500){
            System.out.println("b=500, 线程安全出现问题。");
        }
    }
}

class synDeom2{
	int i = 0;
    synchronized public int get(String a){
        if(a.equals("abc")){
            System.out.println("a set 500");
            i = 500;
        }else{
            System.out.println("b set 10");
            i = 10;
        }
        return i;
    }
}