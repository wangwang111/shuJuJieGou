package paixu;

/*
 * 插入排序
 * 1.直接插入排序
 * 2.折半插入排序
 * 3.希尔排序
 */
public class ChaRu {

	/*
	 * 直接插入排序
	 * 
	 * 初始时，有序区只有一个元素R[0] i=1 ~ n-1,共经过n-1趟排序
	 * 
	 * 时间复杂度：最好O(n),最坏和平均O(n^2)
	 */
	public static void InsertSort(int[] R) {

		int i, j;
		int temp;

		for (i = 1; i < R.length; i++) {
			if (R[i] < R[i - 1]) { 			// 反序时
				temp = R[i];
				j = i - 1;
				do { 						// 找[i]的插入位置
					R[j + 1] = R[j]; 		// 将关键字大人R[i]的纪录后移
					j--;
				} while (j >= 0 && temp < R[j]);

				R[j + 1] = temp; 			// 在j+1处插入R[i]
			}
		}
	}

	/*
	 * 折半插入排序
	 * 
	 * 平均时间复杂度O(n^2),折半插入判刑采用折半查找， 查找效率提高，但移动次数不变,仅仅分散移动变成集中移动
	 */
	static void BinInsertSort(int R[]) {
		int i, j, low, high, mid;
		int temp;
		for (i = 1; i < R.length; i++) {
			if (R[i] < R[i - 1]) {       		 // 反序时
				temp = R[i]; 					// 将R[i]保存到temp中
				low = 0;
				high = i - 1;
				while (low <= high) { 			// 在R[low..high]中查找插入的位置
					mid = low + (high-low) / 2; 	// 取中间位置
					if (temp < R[mid]) {
						high = mid - 1; 		// 插入点在左半区
					} else {
						low = mid + 1; 			// 插入点在右半区
					}
				} 								// 找位置high
				for (j = i - 1; j >= high + 1; j--) { // 纪录后移
					R[j + 1] = R[j];
				}
				R[high+1] = temp; 					// 插入temp
			}
		}
	}

	/*
	 * 希尔排序
	 * 
	 * 思路 
	 * 1.d=d/2 
	 * 2.将排序序列分为d个组，在各组内进行直接插入排序 
	 * 3.递减d=d/2,重复2,直到d=1
	 */
	static void SheelSort(int R[]) {
		int i, j, d;
		int temp;
		d = R.length / 2;					 		// 增量置初值
		while (d > 0) {			
			for (i = d; i < R.length; i++) { 		// 对相隔d位置的元素直接插入排序
				temp = R[i];
				j = i - d;
				while (j >= 0 && temp < R[j]) {
					R[j + d] = R[j];
					j = j - d;
				}
				R[j+d]=temp;
			}
			d = d / 2; 								// 减少增量
		}
	}

	
	public static void main(String[] args) {
		
		int[] a={1,32,2,45,5,12};
		
		for(Integer s:a) {
			System.out.print(s+" ");
		}
	}
	
}
