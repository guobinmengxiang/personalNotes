package algorithm;

import java.math.BigInteger;

public class digui {

	public static void main(String[] args) {
		int i = 1;

		/*
		 * for (i = 1; i <= 20; i++) { System.out.println("兔子第" + i + "个月的总数为:"+
		 * f(i));
		 * 
		 * }
		 * 
		 * System.out.println("相加等于" + fy(100));
		 */
		System.out.println("阶乘" + sum(10));

	}

	/**
	 * @param 斐波那契数列
	 *            ,兔子数列
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
	 * @param 1+100之和
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
	 * @param 阶乘
	 * BigInteger 大数值、
	 * @return x(x-1)
	 */
	public static BigInteger sum(int i) {
		if (i == 1) {
			return BigInteger.ONE;//等价于1
		}
		//* 不能用于大数值，BigInteger.multiply 可用于大数值中相乘
		return BigInteger.valueOf(i).multiply(sum(i - 1));
	}
}
