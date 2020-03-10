package Multithreading;

/**
 * @author 线程的6种状态
 * 新建Thread.State.NEW（Thread.State.NEW 指尚未启动的线程的线程状态。） 
 * new Thread() 之后还没 start () 的时候即是 Thread.State.NEW 状态。
 * 可运行：Thread.State.RUNNABLE 可运行线程的线程状态。处于可运行状态的线程正在 Java 虚拟机中执行，
 * 但它可能正在等待来自操作系统（如处理器）的其他资源。几乎所有运行、运行中都在使用这个状态。
 *阻塞：Thread.State.BLOCKED 等待监视器锁定时被阻止的线程的线程状态。
 *处于阻塞状态的线程正在等待监视器锁进入同步块 / 方法或在调用后重新输入同步块 / 方法
 *用 synchronized 同步锁，锁住该线程之后，其它线程等待这个线程时的等待状态。阻塞状态属于多线程开发中最重要的状态。
 *其中Socket 的 serverSocket.accept() ， netty 中的 IO 多路复用技术，都是采取阻塞 Thread.State.BLOCKED 机制进行设计的。
 *等待：Thread.State.WAITING 指等待线程的线程状态。由于调用以下方法之一，线程处于等待状态：
 *Object.wait()、 Thread.join() LockSupport#park()
 *处于等待状态的线程正在等待另一个线程执行特定操作。例如，对某个对象调用了 Object.wait() 
 *的线程正在等待另一个线程对该对象调用 Object.notify() 或 Object.notifyAll() 。调
 *用了 thread.join() 的线程正在等待指定线程终止。 
 *计时等待：Thread.State.TIMED_WAITING 具有指定等待时间的等待线程的线程状态。由于使用指定的正等待时间调用以下方法之一，线程处于定时等待状态
 *Thread.sleep() Object#wait(long) Thread#join(long) LockSupport#parkNanos LockSupport#parkUntil
 *终止：Thread.State.TERMINATED 线程已执行完成	
 */
public class Demo6 {

	public static void main(String[] args) {
		System.out.println(Thread.State.NEW);
		System.out.println(Thread.State.RUNNABLE);
		System.out.println(Thread.State.BLOCKED);
		System.out.println(Thread.State.WAITING);
		System.out.println(Thread.State.TIMED_WAITING);
		System.out.println(Thread.State.TERMINATED);
	}

}


