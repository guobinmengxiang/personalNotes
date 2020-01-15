package algorithm;

import java.math.BigInteger;

public class digui {

	public static void main(String[] args) {
		int i = 1;

		/*
		 * for (i = 1; i <= 20; i++) { System.out.println("���ӵ�" + i + "���µ�����Ϊ:"+
		 * f(i));
		 * 
		 * }
		 * 
		 * System.out.println("��ӵ���" + fy(100));
		 */
		System.out.println("�׳�" + sum(10));

	}

	/**
	 * @param 쳲���������
	 *            ,��������
	 * @return f1=1,f2=1; F(n)=F(n-1)+F(n-2)
	 */
	public static int f(int x) {
		if (x == 1 || x == 2) {
			return 1;
		} else {
			return f(x - 1) + f(x - 2);
		}
	}

	/**
	 * @param 1+100֮��
	 * @return x+(x-1)
	 */
	public static int fy(int x) {
		if (x == 1) {
			return 1;
		} else {
			return x + fy(x - 1);
		}
	}

	/**
	 * @param �׳�
	 * BigInteger ����ֵ��
	 * @return x(x-1)
	 */
	public static BigInteger sum(int i) {
		if (i == 1) {
			return BigInteger.ONE;//�ȼ���1
		}
		//* �������ڴ���ֵ��BigInteger.multiply �����ڴ���ֵ�����
		return BigInteger.valueOf(i).multiply(sum(i - 1));
	}
}
