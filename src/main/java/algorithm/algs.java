package algorithm;

public class algs {

	public static void main(String[] args) {
		printing2(35,94);

	}
	/**
	 * @param ��Ҫ��ӡ�ķ���
	 * @param ��ӡ����
	 * ����
	 * *
	 * **
	 * ***
	 */
	public static void printing(String str,int str1){
		for(int i=1;i<=str1;i++){
			for(int j=1;j<=i;j++){
		System.out.print(str);
		}
			System.out.println(" ");
		}
	}
	
	/**
	 * @param ��Ҫ��ӡ�ķ���
	 * @param ��ӡ����
	 * ����
	 * ***
	 * **
	 * *
	 */
	public static void printing1(String str,int str1){
		for(int i=1;i<=str1;i++){
			for(int j=i;j<=str1;j++){
		System.out.print(str);
		}
			System.out.println(" ");
		}
	}
	
	/**
	 * ��ٷ�
	 * ����ͬ���������
	 * @param ����������
	 * @param ����ֻ��
	 */
	public static void printing2(int str,int str1){
	   int ji=0;
	   int tu=0;
	   for(int i=1;i<str;i++){
		  if(2*i+(35-i)*4==str1){
			  ji=i;tu=35-i;
			  System.out.println("ji"+ji+",,tu"+tu);
			  break;
		  }
	   }
	}
}
