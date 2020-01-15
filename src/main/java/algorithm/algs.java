package algorithm;

public class algs {

	public static void main(String[] args) {
		printing2(35,94);

	}
	/**
	 * @param 需要打印的符号
	 * @param 打印几行
	 * 正序
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
	 * @param 需要打印的符号
	 * @param 打印几行
	 * 倒序
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
	 * 穷举法
	 * 鸡兔同笼搞基问题
	 * @param 动物总数量
	 * @param 多少只脚
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
