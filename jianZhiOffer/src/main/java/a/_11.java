package a;

public class _11 {

	/*
	 * 旋转数组中最小值
	 * 输入一个递增排序的数组的一个旋转，输出旋转旋转数组的最小元素
	 * 
	 * 如果从头遍历时间复杂度O(n)，采用二分查找，时间复杂度O(log2^2N)
	 * 
	 * 数组在一定程度上是排序的，可以采用二分查找法
	 * 用两个指针分别指向数组的第一个元素和最后一个元素，（第一个元素应该是大于或者等于最后一个
	 * 元素的，还有特例）
	 * 
	 * 取数组中间的元素
	 * 1.如果该中间元素大于或者等于的哥指针，第一个指针指向该中间元素
	 * 2.如果该中间元素小于或者等于的哥指针，第二个指针指向该中间元素
	 * 
	 * 循环条件：它们最终会指向两个相邻的元素，而第二个指针指向的刚好是最小的元素
	 * 
	 * 特例：
	 * 1, 1, 1, 0, 1
	 * 不得不采用顺序查找
	 */
	int findMin(int[] arr) {
		if (arr == null || arr.length <= 0)
			throw new RuntimeException("Invalid parameters");

		int low = 0;
		int high = arr.length - 1;
		int mid = low;
		while (arr[low] >= arr[high]) {
			// 如果low和high指向相邻的两个数，
			// 则low指向第一个递增子数组的最后一个数字，
			// high指向第二个子数组的第一个数字，也就是数组中的最小数字
			if (high - low == 1) {
				mid = high;
				break;
			}

			// 如果下标为low、high和mid指向的三个数字相等，
			// 则只能顺序查找
			mid = low + (high - low) / 2;
			if (arr[low] == arr[high] && arr[mid] == arr[low])
				return minInOrder(arr, low, high);

			/*
			 * 和二分查找一样，我们用两个指针指向数组的第一个元素和最后一个元素，
			 * 第一个元素应该大于或等于最后一个元素（还有特例）
			 * 
			 * 查找中间元素：
			 * 如果该中间元素位于前面的递增子数组，那么它应该大于或等于第一个指针的元素。
			 * 此时数组中最小元素应该位于中间元素的后面，把第一个指针指向中间元素
			 * 
			 * 如果中间元素位于后面的递增子序列，那么它应该小于或者等于第二个指针指向元素，
			 * 那么最小元素应该位于前面，把第二个指针指向中间元素
			 */
			// 缩小查找范围
			if (arr[mid] >= arr[low])
				low = mid;
			else if (arr[mid] <= arr[high])
				high = mid;
		}

		return arr[mid];
	}

	int minInOrder(int[] arr, int low, int high) {
		int result = arr[low];
		for (int i = low + 1; i <= high; ++i) {
			if (result > arr[i])
				result = arr[i];
		}

		return result;
	}

	
	public static void main(String[] args) {
		_11 a=new _11();
		int i=a.findMin(new int[] {3,4,5,2,3});
		System.out.println(i);
	}
}