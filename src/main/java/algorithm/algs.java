package algorithm;

public class algs {

	public static void main(String[] args) {
	printing1("*",5);

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
	
	public static void printing2(String str,int str1){
		for(int i=1;i<=str1;i++){
			for(int j=i;j<=str1;j++){
				System.out.print(" ");		
		System.out.print(str);
		}
			System.out.println(" ");
		}
	}
}
