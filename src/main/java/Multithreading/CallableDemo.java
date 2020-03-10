package Multithreading;

import java.util.concurrent.Callable;
/**
 * 
如果想实现多线程并且具有返回值的情况下，需要实现 Callable<V> 接口 
实现 Runnable 的类，需要通过 new Thread(myRunnable).start(); 的方式进行启动 
即实现 Runnable 的类只是做好了一段多线程所需执行的内容，自身并没有执行的能力，
需要通过 Thread 类的 .start() 函数进行启动。
实现 Callable<V> 的接口，含有 .call() 函数，所以可以直接使用 .call() 函数进行启动，
另外值得说明的是，Callable<V> 函数具有返回值，返回值为定义类时使用的 <V> 类型，其定义是其返回
Callable<V> 在需要使用返回值的情况下，程序是同步运行的
Callable<V> 其它情况下，程序是异步运行的
 */
public class CallableDemo {

	public static void main(String[] args) {
		MyCallable mc= new MyCallable("慈世平");
		String cal=null;
		try {
			cal=mc.call();
		} catch (Exception e) {
			 e.printStackTrace();
		}
		System.out.println(cal);
	}

}

class MyCallable implements Callable<String>{
	private String name;
	public MyCallable (String name){
		this.name=name;
	}
	
	public String call() throws Exception{
		return "name:"+name;
		
	}
}
