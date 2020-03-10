package DesignPattern;

/**
 * @author 单例
 *单例模式又叫做 Singleton模式，指的是一个类，在一个JVM里，只有一个实例存在。
 *饿汉式是立即加载的方式，无论是否会用到这个对象，都会加载。
 *如果在构造方法里写了性能消耗较大，占时较久的代码，比如建立与数据库的连接，那么就会在启动的时候感觉稍微有些卡顿。
 *懒汉式，是延迟加载的方式，只有使用的时候才会加载。 并且有线程安全的考量(鉴于同学们学习的进度，暂时不对线程的章节做展开)。
 *使用懒汉式，在启动的时候，会感觉到比饿汉式略快，因为并没有做对象的实例化。 但是在第一次调用的时候，会进行实例化操作，感觉上就略慢。
 *看业务需求，如果业务上允许有比较充分的启动和初始化时间，就使用饿汉式，否则就使用懒汉式
 */
public class Singleton {
	public static void main(String[] args) {
		// 无法通过new实例化对象，不信你就试试，会报错
		//GiantDragon gd = new GiantDragon();
		//只能通过getinstance(),获取
		GiantDragon gb = GiantDragon.getinstance();
		GiantDragon gb2 = GiantDragon.getinstance();
		//输出你会发现它是同一个对象
		System.out.println(gb==gb2);
	}
}

/*单例的好处：
对于频繁使用的对象，可以省略创建对象所花费的时间，
由于new 次数的减少，因而对系统内存的使用频率也会降低，减轻gc压力，缩短gc停顿时间；
总之一句话，善用单例，可以有效的改善系统性能*/
