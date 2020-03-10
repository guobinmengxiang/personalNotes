package Multithreading;

/**
 * @author �����߳�
 * �����̵߳Ķ��ַ�ʽ���̳��߳��ࡢʵ��Runnable�ӿ�
 * ��ִ��start()֮ǰ������Ϊ�߳��������ȼ�
 *  t1.setPriority(Thread.MAX_PRIORITY);
 *  t2.setPriority(Thread.MIN_PRIORITY);
 */
public class EstablishThread {

	public static void main(String[] args) {
		  Hero gareen = new Hero();
	        gareen.name = "����";
	        gareen.hp = 616;
	        gareen.damage = 50;
	 
	        Hero teemo = new Hero();
	        teemo.name = "��Ī";
	        teemo.hp = 300;
	        teemo.damage = 30;
	         
	        Hero bh = new Hero();
	        bh.name = "�ͽ�����";
	        bh.hp = 500;
	        bh.damage = 65;
	         
	        Hero leesin = new Hero();
	        leesin.name = "äɮ";
	        leesin.hp = 455;
	        leesin.damage = 80;
	        KillThread k1 = new KillThread(gareen,teemo);
	        k1.start();
	        //battle2����ʵ����Runnable�ӿڣ�������run����������ֱ�ӵ���run����������������һ���µ��̡߳�
	        //���룬����һ���̶߳����start()�������Ż�����һ���µ��̡߳�
	        Battle battle2 = new Battle(bh,leesin);
	        new Thread(battle2).start();
	        
	}

}

/**
 * @author �̳�Thread
 *
 */
class KillThread extends Thread{
	private Hero h1;
	private Hero h2;
	
	public KillThread( Hero h1,Hero h2){
		this.h1=h1;
		this.h2=h2;                        
		
	}
	
	public void run(){
		//Ѫ���Ƿ�С��0
        while(!h2.isDead()){
            h1.attackHero(h2);
        }
    }
}

 /**
 * @author ʵ�� Runable
 * ��Ȼ�м̳з�ʽ�ˣ�ΪɶҪʵ�ֽӿ��أ���Ϊjava�����ܶ�̳У������ǰ���м̳��ˣ�����զ�죿
 *
 */
class Battle implements Runnable{
    
    private Hero h1;
    private Hero h2;
 
    public Battle(Hero h1, Hero h2){
        this.h1 = h1;
        this.h2 = h2;
    }
 
    public void run(){
        while(!h2.isDead()){
            h1.attackHero(h2);
        }
    }
}




/**
 * @author �����߳�
 * ��˵����һ��������Ĵ�����ʽ�����û�о�����������
 *
 */
