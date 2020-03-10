package Multithreading;

/**
 * @author �̵߳�6��״̬
 * �½�Thread.State.NEW��Thread.State.NEW ָ��δ�������̵߳��߳�״̬���� 
 * new Thread() ֮��û start () ��ʱ���� Thread.State.NEW ״̬��
 * �����У�Thread.State.RUNNABLE �������̵߳��߳�״̬�����ڿ�����״̬���߳����� Java �������ִ�У�
 * �����������ڵȴ����Բ���ϵͳ���紦��������������Դ�������������С������ж���ʹ�����״̬��
 *������Thread.State.BLOCKED �ȴ�����������ʱ����ֹ���̵߳��߳�״̬��
 *��������״̬���߳����ڵȴ�������������ͬ���� / �������ڵ��ú���������ͬ���� / ����
 *�� synchronized ͬ��������ס���߳�֮�������̵߳ȴ�����߳�ʱ�ĵȴ�״̬������״̬���ڶ��߳̿���������Ҫ��״̬��
 *����Socket �� serverSocket.accept() �� netty �е� IO ��·���ü��������ǲ�ȡ���� Thread.State.BLOCKED ���ƽ�����Ƶġ�
 *�ȴ���Thread.State.WAITING ָ�ȴ��̵߳��߳�״̬�����ڵ������·���֮һ���̴߳��ڵȴ�״̬��
 *Object.wait()�� Thread.join() LockSupport#park()
 *���ڵȴ�״̬���߳����ڵȴ���һ���߳�ִ���ض����������磬��ĳ����������� Object.wait() 
 *���߳����ڵȴ���һ���̶߳Ըö������ Object.notify() �� Object.notifyAll() ����
 *���� thread.join() ���߳����ڵȴ�ָ���߳���ֹ�� 
 *��ʱ�ȴ���Thread.State.TIMED_WAITING ����ָ���ȴ�ʱ��ĵȴ��̵߳��߳�״̬������ʹ��ָ�������ȴ�ʱ��������·���֮һ���̴߳��ڶ�ʱ�ȴ�״̬
 *Thread.sleep() Object#wait(long) Thread#join(long) LockSupport#parkNanos LockSupport#parkUntil
 *��ֹ��Thread.State.TERMINATED �߳���ִ�����	
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


