package Multithreading;

import java.util.concurrent.Callable;
/**
 * 
�����ʵ�ֶ��̲߳��Ҿ��з���ֵ������£���Ҫʵ�� Callable<V> �ӿ� 
ʵ�� Runnable ���࣬��Ҫͨ�� new Thread(myRunnable).start(); �ķ�ʽ�������� 
��ʵ�� Runnable ����ֻ��������һ�ζ��߳�����ִ�е����ݣ�����û��ִ�е�������
��Ҫͨ�� Thread ��� .start() ��������������
ʵ�� Callable<V> �Ľӿڣ����� .call() ���������Կ���ֱ��ʹ�� .call() ��������������
����ֵ��˵�����ǣ�Callable<V> �������з���ֵ������ֵΪ������ʱʹ�õ� <V> ���ͣ��䶨�����䷵��
Callable<V> ����Ҫʹ�÷���ֵ������£�������ͬ�����е�
Callable<V> ��������£��������첽���е�
 */
public class CallableDemo {

	public static void main(String[] args) {
		MyCallable mc= new MyCallable("����ƽ");
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
