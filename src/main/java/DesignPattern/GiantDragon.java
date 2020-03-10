package DesignPattern;

/**
 * @author 饿汉式单例
 *饿汉式单例模式，无论如何都会创建一个实例
 *这个饿汉式吧，有一个巨大的问题，就是instance成员变量是由static修饰的，因此在jvm加载单例类时，单例对象就会被创建
 *如果这个单例类在系统中还扮演着其他角色，那么任何使用这个单例类的地方都会初始化这个单例变量，如果创建过程非常慢，你说是不是会影响效率
 */
public class GiantDragon {
	//私有化构造方法使得该类无法在外部通过new 进行实例化
	private GiantDragon(){	
	}
	//准备一个类属性，指向实例化对象，因为是类属性，所以只有一个。
	private static GiantDragon instance = new GiantDragon();
	//public static方法，提供给调用者获取定义的对象
	public static GiantDragon getinstance(){
		return instance;
	}
	
	//一下注释掉的代码作用是，阻止生成新的实例，总是返回当前对象
    //使用场景；序列化和反序列化可能会破坏单例，生成多个对象实例，对单例实现系列化和反序列化的场景并不多见，但如果存在，要注意
/*	private Object readResolve(){
		return instance;
	}*/
}


/**
 *1. 构造方法私有化
 *2. 静态属性指向实例
 *3. public static的 getInstance方法，返回第二步的静态属性
 */
