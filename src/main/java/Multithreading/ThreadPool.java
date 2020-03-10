package Multithreading;

import java.util.LinkedList;

/**
 * 每一个线程的启动和结束都是比较消耗时间和占用资源的。
 *如果在系统中用到了很多的线程，大量的启动和结束动作会导致系统的性能变卡，响应变慢
 *为了解决这个问题，引入线程池这种设计思想
 *线程池的模式很像生产者消费者模式，消费的对象是一个一个的能够运行的任务
 */
public class ThreadPool {
	//线程池大小
 int poolSize;
 //任务容器
 LinkedList<Runnable> tasks = new LinkedList<>();
 //试图消费任务的线程
 public ThreadPool() {
	 poolSize = 10;
     // 启动10个任务消费者线程
     synchronized (tasks) {
         for (int i = 0; i < poolSize; i++) {
             new TaskConsumeThread("任务消费者线程 " + i).start();
         }
     }
 }

public void add(Runnable r) {
    synchronized (tasks) {
        tasks.add(r);
        // 唤醒等待的任务消费者线程
        tasks.notifyAll();
    }
}

class TaskConsumeThread extends Thread {
    public TaskConsumeThread(String name) {
        super(name);
    }

    Runnable task;

    public void run() {
        System.out.println("启动： " + this.getName());
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
                // 允许添加任务的线程可以继续添加任务
                tasks.notifyAll();

            }
            System.out.println(this.getName() + " 获取到任务，并执行");
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
                //System.out.println("执行任务");
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

