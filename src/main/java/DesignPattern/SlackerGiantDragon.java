package DesignPattern;

/**
 * @author 懒汉式单例
 *懒汉式单例模式与饿汉式单例模式不同，只有在调用getInstance的时候，才会创建实例
 */
public class SlackerGiantDragon {
	//私有化构造方法使得该类无法在外部通过new 进行实例化
	private SlackerGiantDragon(){	
	}
	//准备一个类属性，指向实例化对象，因为是类属性，所以只有一个。
	private static SlackerGiantDragon instance=null ;
	//public static方法，提供给调用者获取定义的对象
	//在这里为什么要用synchronized ,单线程你可以不加，如果是多线程，你想想，你的null==instance,会不会出现误判的情况
	//加了同步关键字，在多线程环境中，他的时耗要远远大于饿汉式，而且相差很大，有点得不偿失；
	public static synchronized SlackerGiantDragon getinstance(){
		if(null==instance){
			instance=new SlackerGiantDragon();
		}
		return instance;
	}
}
