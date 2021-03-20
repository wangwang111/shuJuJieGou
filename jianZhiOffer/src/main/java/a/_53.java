package a;

public class _53 {

	/*
	 * 题目一
	 * 数字在排列数组中出现的次数
	 * 
	 * 基于快排查找，找第一个k和最后一个k位置，如果中间元素等于k且前面的元素小于k，则是第一个元素
	 * 
	 * 题目二 
	 * 长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0~n-1内n个数字中，
	 * 有且仅有一个数字不在该数组中，找出该数
	 *
	 * 二分查找
	 * 如果中间元素和下标相同，下一轮查找只需要查找右半边
	 * 如果中间元素的值和下标不相等，并且它前面一个元素和它的下标相等，意味着这个中间元素的数字正好是第一个值和下标不相等的元素
	 * 如果中间元素的值和下标不相等，并且它前面一个元素和它的下标不相等，这意味着下一轮查找左边元素
	 * 
	 * 题目三
	 * 数组中数值和下标相等的元素
	 * 单调递增的数组里的每个元素都是整数并且是唯一的，找出数组中任意一个数值等于其下标元素
	 * 
	 * 遍历数组中的数字，时间复杂度O(n)
	 * 
	 * 单调递增，可以使用二分查找
	 * 如果数组的第i个元素和下标相等，即找到了一个数字和其下标相等
	 * 如果数字m大于下标，左边查找
	 * 如果数字m小于下标，右边查找
	 */

	int GetNumberOfK(int[] data, int length, int k) {
		int number = 0;

		if (data != null && length > 0) {
			int first = GetFirstK(data, length, k, 0, length - 1);
			int last = GetLastK(data, length, k, 0, length - 1);

			if (first > -1 && last > -1)
				number = last - first + 1;
		}

		return number;
	}

	// 找到数组中第一个k的下标。如果数组中不存在k，返回-1
	int GetFirstK(int[] data, int length, int k, int start, int end) {
		if (start > end)
			return -1;

		int middleIndex = (start + end) / 2;
		int middleData = data[middleIndex];

		if (middleData == k) {
			if ((middleIndex > 0 && data[middleIndex - 1] != k) || middleIndex == 0)
				return middleIndex;
			else
				end = middleIndex - 1;
		} else if (middleData > k) {
			end = middleIndex - 1;
		} else {
			start = middleIndex + 1;
		}

		return GetFirstK(data, length, k, start, end);
	}

	// 找到数组中最后一个k的下标。如果数组中不存在k，返回-1
	int GetLastK(int[] data, int length, int k, int start, int end) {
		if (start > end)
			return -1;

		int middleIndex = (start + end) / 2;
		int middleData = data[middleIndex];

		if (middleData == k) {
			if ((middleIndex < length - 1 && data[middleIndex + 1] != k) || middleIndex == length - 1)
				return middleIndex;
			else
				start = middleIndex + 1;
		} else if (middleData < k)
			start = middleIndex + 1;
		else
			end = middleIndex - 1;

		return GetLastK(data, length, k, start, end);
	}

	
	// ==============================题目二===========================

	int GetMissingNumber(int[] numbers, int length) {
		if (numbers == null || length <= 0)
			return -1;

		int left = 0;
		int right = length - 1;
		while (left <= right) {
			int middle = (right + left) >> 1;
			if (numbers[middle] != middle) {
				if (middle == 0 || numbers[middle - 1] == middle - 1)
					return middle;
				right = middle - 1;
			} else
				left = middle + 1;
		}

		if (left == length)
			return length;

		// 无效的输入，比如数组不是按要求排序的，
		// 或者有数字不在0到n-1范围之内
		return -1;
	}

	
	
	// ==============================题目三===========================
	
	int GetNumberSameAsIndex(int[] numbers, int length) {
		if (numbers == null || length <= 0)
			return -1;

		int left = 0;
		int right = length - 1;
		while (left <= right) {
			int middle = left + ((right - left) >> 1);
			if (numbers[middle] == middle)
				return middle;

			if (numbers[middle] > middle)
				right = middle - 1;
			else
				left = middle + 1;
		}

		return -1;
	}

}
