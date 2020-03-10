package Multithreading;

/**
 * @author 创建线程
 * 创建线程的二种方式：继承线程类、实现Runnable接口
 * 在执行start()之前，可以为线程设置优先级
 *  t1.setPriority(Thread.MAX_PRIORITY);
 *  t2.setPriority(Thread.MIN_PRIORITY);
 */
public class EstablishThread {

	public static void main(String[] args) {
		  Hero gareen = new Hero();
	        gareen.name = "盖伦";
	        gareen.hp = 616;
	        gareen.damage = 50;
	 
	        Hero teemo = new Hero();
	        teemo.name = "提莫";
	        teemo.hp = 300;
	        teemo.damage = 30;
	         
	        Hero bh = new Hero();
	        bh.name = "赏金猎人";
	        bh.hp = 500;
	        bh.damage = 65;
	         
	        Hero leesin = new Hero();
	        leesin.name = "盲僧";
	        leesin.hp = 455;
	        leesin.damage = 80;
	        KillThread k1 = new KillThread(gareen,teemo);
	        k1.start();
	        //battle2对象实现了Runnable接口，所以有run方法，但是直接调用run方法，并不会启动一个新的线程。
	        //必须，借助一个线程对象的start()方法，才会启动一个新的线程。
	        Battle battle2 = new Battle(bh,leesin);
	        new Thread(battle2).start();
	        
	}

}

/**
 * @author 继承Thread
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
		//血量是否小于0
        while(!h2.isDead()){
            h1.attackHero(h2);
        }
    }
}

 /**
 * @author 实现 Runable
 * 既然有继承方式了，为啥要实现接口呢，因为java本身不能多继承，如果当前类有继承了，那你咋办？
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
 * @author 创建线程
 * 听说还有一种匿名类的创建方式，这个没研究，后续补充
 *
 */
