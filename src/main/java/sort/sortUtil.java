package sort;

/**
 * @author ����
 *
 */
public class sortUtil {
	
	public static void main(String[] args) {
		int a[] = new int[]{12,2,34,45,23,16,32,1};
		//xuanze(a);
		bubbling(a);
	}
	/**
	 * @param ѡ������
	 * �ѵ�һλ���������еĽ��бȽϣ�ֻҪ�ȵ�һλС�ģ��ͻ�����һ��λ����
	 * Ȼ���ٴӵڶ�λ��ʣ����������н��бȽϣ�ֻҪ�ȵڶ�λС���ͻ����ڶ���λ���� 
	 * 
	 */
	public static void xuanze( int a[]){
		
		for(int j=0;j<a.length;j++){
			for(int jj=j+1;jj<a.length;jj++){
				if(a[j]>a[jj]){
					int temp=a[jj];
					a[jj]=a[j];
					a[j]=temp;
					
				}
			}
		
		}
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
	
	/**
	 * @param ð������
	 * ��һ�����ӵ�һλ��ʼ����������λ���бȽ� 
	 * �������ǰ��ıȺ���Ĵ󣬾ͰѴ�����ݽ����ں��棬ѭ���Ƚ���Ϻ����һλ�������� 
	 * �ڶ����� ����һ�Σ�ֻ�������ñȽ����һλ 
	 */
	public static void bubbling( int a[]){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length-1-i;j++){
				if(a[j]>a[j+1]){
					int temp=a[j+1];
					a[j+1]=a[j];
					a[j]=temp;
					
				}
			}
		}
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}

}
