package Multithreading;

import java.util.LinkedList;

/**
 * ÿһ���̵߳������ͽ������ǱȽ�����ʱ���ռ����Դ�ġ�
 *�����ϵͳ���õ��˺ܶ���̣߳������������ͽ��������ᵼ��ϵͳ�����ܱ俨����Ӧ����
 *Ϊ�˽��������⣬�����̳߳��������˼��
 *�̳߳ص�ģʽ����������������ģʽ�����ѵĶ�����һ��һ�����ܹ����е�����
 */
public class ThreadPool {
	//�̳߳ش�С
 int poolSize;
 //��������
 LinkedList<Runnable> tasks = new LinkedList<>();
 //��ͼ����������߳�
 public ThreadPool() {
	 poolSize = 10;
     // ����10�������������߳�
     synchronized (tasks) {
         for (int i = 0; i < poolSize; i++) {
             new TaskConsumeThread("�����������߳� " + i).start();
         }
     }
 }

public void add(Runnable r) {
    synchronized (tasks) {
        tasks.add(r);
        // ���ѵȴ��������������߳�
        tasks.notifyAll();
    }
}

class TaskConsumeThread extends Thread {
    public TaskConsumeThread(String name) {
        super(name);
    }

    Runnable task;

    public void run() {
        System.out.println("������ " + this.getName());
        while (true) {
            synchronized (tasks) {
                while (tasks.isEmpty()) {
                    try {
                        tasks.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                task = tasks.removeLast();
                // �������������߳̿��Լ����������
                tasks.notifyAll();

            }
            System.out.println(this.getName() + " ��ȡ�����񣬲�ִ��");
            task.run();
        }
    }
}

public static void main(String[] args) {
    ThreadPool pool= new ThreadPool();
    int sleep=1000;
    while(true){
        pool.add(new Runnable(){
            @Override
            public void run() {
                //System.out.println("ִ������");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        try {
            Thread.sleep(sleep);
            sleep = sleep>100?sleep-100:sleep;
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
          
    }
      
}
}

