package Multithreading;
/**
 * @author ʵ���������̲߳���ȫ�ģ������ڵı������̰߳�ȫ�ģ�
 *����߳���Ҫ�������ReturnSomething����Ϊ����߳���Ҫ��������������̹߳���һ����������ͬ���ģ������첽
 */
public class synchronizedDemo1{
    public static void main(String[] args){
    	//ʵ����������
        ReturnSomething returnSomething = new ReturnSomething();
        for(int i=0;i<2000;i++){
        	//����2000���߳�
            Thread a = new ThreadA1(returnSomething);
            a.start();
            Thread b = new ThreadB(returnSomething);
            b.start();
        }
    }
}

class ReturnSomething{
	//ʵ������Ϊ���̰߳�ȫ�ģ������ڱ������̰߳�ȫ��
    int i = 0;
    /**
     * @param ��ʱ�������synchronized�Ļ����Ƿ��̰߳�ȫ��
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
    	//�̳��޲ι��췽��
        super();
        this.returnSomething = returnSomething;
    }
    @Override
    public void run(){
        int a = returnSomething.get("abc");
        if(a == 10){
            System.out.println("a=10, �̰߳�ȫ�������⡣");
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
            System.out.println("b=500, �̰߳�ȫ�������⡣");
        }
    }
}

