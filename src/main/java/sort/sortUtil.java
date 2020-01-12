package sort;

/**
 * @author 排序
 *
 */
public class sortUtil {
	
	public static void main(String[] args) {
		int a[] = new int[]{12,2,34,45,23,16,32,1};
		//xuanze(a);
		bubbling(a);
	}
	/**
	 * @param 选择排序法
	 * 把第一位和其他所有的进行比较，只要比第一位小的，就换到第一个位置来
	 * 然后再从第二位和剩余的其他所有进行比较，只要比第二位小，就换到第二个位置来 
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
	 * @param 冒泡排序法
	 * 第一步：从第一位开始，把相邻两位进行比较 
	 * 如果发现前面的比后面的大，就把大的数据交换在后面，循环比较完毕后，最后一位就是最大的 
	 * 第二步： 再来一次，只不过不用比较最后一位 
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
