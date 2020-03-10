package DesignPattern;

/**
 * @author ����ʽ����
 *����ʽ����ģʽ��������ζ��ᴴ��һ��ʵ��
 *�������ʽ�ɣ���һ���޴�����⣬����instance��Ա��������static���εģ������jvm���ص�����ʱ����������ͻᱻ����
 *��������������ϵͳ�л�������������ɫ����ô�κ�ʹ�����������ĵط������ʼ�������������������������̷ǳ�������˵�ǲ��ǻ�Ӱ��Ч��
 */
public class GiantDragon {
	//˽�л����췽��ʹ�ø����޷����ⲿͨ��new ����ʵ����
	private GiantDragon(){	
	}
	//׼��һ�������ԣ�ָ��ʵ����������Ϊ�������ԣ�����ֻ��һ����
	private static GiantDragon instance = new GiantDragon();
	//public static�������ṩ�������߻�ȡ����Ķ���
	public static GiantDragon getinstance(){
		return instance;
	}
	
	//һ��ע�͵��Ĵ��������ǣ���ֹ�����µ�ʵ�������Ƿ��ص�ǰ����
    //ʹ�ó��������л��ͷ����л����ܻ��ƻ����������ɶ������ʵ�����Ե���ʵ��ϵ�л��ͷ����л��ĳ��������������������ڣ�Ҫע��
/*	private Object readResolve(){
		return instance;
	}*/
}


/**
 *1. ���췽��˽�л�
 *2. ��̬����ָ��ʵ��
 *3. public static�� getInstance���������صڶ����ľ�̬����
 */
