package chazhao;

/*
 * 顺序查找
 * 二分查找
 * 分块查找
 */
public class ChaoZhao {

	/*
	 * 顺序查找
	 * 
	 * 时间复杂度O(n)
	 */
	int seqSearch(int arr[],int key) {
		int i=0;
		while(i<arr.length && arr[i]!=key)		//从表头开始找
			i++;
		if(i>=arr.length)
			return -1;						//未找到返回-1
		else{
			return i+1;						//找到返回逻辑序号i+1
		}
	}
	
	/*
	 * 二分查找(有序排列)
	 *
	 * 要求表中关键字有序排列
	 */
	static int binSearch(int[] arr,int key) {
		int low=0,high=arr.length,mid;
		
		while(low <= high) {
			mid=low+(high-low)/2;
		
			if (key==arr[mid]) {
				return mid+1;
			}
			if (key<arr[mid]) { 
				high=mid-1;
			} else {
				low=mid+1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int [] R= {1,2,3,4};
		int result=binSearch(R,2);
		System.out.println(result);
	}
		
}