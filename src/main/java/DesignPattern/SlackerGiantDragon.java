package DesignPattern;

/**
 * @author ����ʽ����
 *����ʽ����ģʽ�����ʽ����ģʽ��ͬ��ֻ���ڵ���getInstance��ʱ�򣬲Żᴴ��ʵ��
 */
public class SlackerGiantDragon {
	//˽�л����췽��ʹ�ø����޷����ⲿͨ��new ����ʵ����
	private SlackerGiantDragon(){	
	}
	//׼��һ�������ԣ�ָ��ʵ����������Ϊ�������ԣ�����ֻ��һ����
	private static SlackerGiantDragon instance=null ;
	//public static�������ṩ�������߻�ȡ����Ķ���
	//������ΪʲôҪ��synchronized ,���߳�����Բ��ӣ�����Ƕ��̣߳������룬���null==instance,�᲻��������е����
	//����ͬ���ؼ��֣��ڶ��̻߳����У�����ʱ��ҪԶԶ���ڶ���ʽ���������ܴ��е�ò���ʧ��
	public static synchronized SlackerGiantDragon getinstance(){
		if(null==instance){
			instance=new SlackerGiantDragon();
		}
		return instance;
	}
}
