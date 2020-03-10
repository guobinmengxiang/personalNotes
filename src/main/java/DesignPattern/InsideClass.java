package DesignPattern;

/**
 * @author 使用内部类的方式来创建单例
 *内部类实现单例的好处：既做到了延迟加载，又不用同步关键字
 *原理：InsideClass被加载时，内部类不会被初始化，而当getInstance被调用时才会加载SingletonHolder，并初始化instance
 */
public class InsideClass {

	private InsideClass(){
		System.out.println("初始化构造方法");
	}
	/**
	 * @author 内部类
	 *
	 */
	private static class SingletonHolder{
		private static InsideClass instance = new InsideClass();
		
	}
	public static InsideClass getInstance(){
		return SingletonHolder.instance;
	}


}

/*写到这其实单例类的创建基本已经完善了，但仍有例外情况
比如通过反射机制，强行调用单例类的私有构造函数，生成多个实例，但这种方式有点极端，不讨论了*/
