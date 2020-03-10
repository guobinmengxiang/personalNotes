package DesignPattern;

/**
 * @author ʹ���ڲ���ķ�ʽ����������
 *�ڲ���ʵ�ֵ����ĺô������������ӳټ��أ��ֲ���ͬ���ؼ���
 *ԭ��InsideClass������ʱ���ڲ��಻�ᱻ��ʼ��������getInstance������ʱ�Ż����SingletonHolder������ʼ��instance
 */
public class InsideClass {

	private InsideClass(){
		System.out.println("��ʼ�����췽��");
	}
	/**
	 * @author �ڲ���
	 *
	 */
	private static class SingletonHolder{
		private static InsideClass instance = new InsideClass();
		
	}
	public static InsideClass getInstance(){
		return SingletonHolder.instance;
	}


}

/*д������ʵ������Ĵ��������Ѿ������ˣ��������������
����ͨ��������ƣ�ǿ�е��õ������˽�й��캯�������ɶ��ʵ���������ַ�ʽ�е㼫�ˣ���������*/
