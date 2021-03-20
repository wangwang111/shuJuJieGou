package a;

public class _39 {

	/*
	 * 数组中出现次数超过一半的数字
	 * 
	 * 排序好的数字，很容易统计每个数字出现的次数，排序时间复杂度O(log^2)
	 * 
	 * 优化:
	 * 时间复杂度O(log^2)
	 * 数组中中间位置的元素一定是数组中出现次数超过一半的数字
	 * 利用快排，随机选一个数字，然后调整数组中的顺序
	 * 如果这个数字的下标刚好是n/2，那么这个数字就是中位数，
	 * 如果它的下标大于n/2，中位数在它的左边
	 * 如果它的下标小于n/2，中位数在它的右边
	 */
	int MoreThanHalfNum_Solution1(int[] numbers) {
		if (CheckInvalidArray(numbers, numbers.length))
			return 0;

		int middle = numbers.length / 2;
		int start = 0;
		int end = numbers.length - 1;
		int index = Partition(numbers, start, end);
		while (index != middle) {
			if (index > middle) {
				end = index - 1;
				index = Partition(numbers, start, end);
			} else {
				start = index + 1;
				index = Partition(numbers, start, end);
			}
		}

		int result = numbers[middle];
		if (!CheckMoreThanHalf(numbers, numbers.length, result))
			result = 0;

		return result;
	}

	private int Partition(int[] numbers, int s, int t) {
		int i = s, j = t;
		int temp;
		temp = numbers[s]; // 用区间的第一个记录作为基准
		while (i != j) { // 从两端交替向中间扫描，直至i=j为止
			while (i < j && numbers[j] >= temp)
				j--;
			numbers[i] = numbers[j];
			while (i < j && numbers[i] <= temp)
				i++;
			numbers[j] = numbers[i];
		}
		numbers[i] = temp;
		return i;
	}

	private boolean g_bInputInvalid;

	boolean CheckInvalidArray(int[] numbers, int length) {
		g_bInputInvalid = false;
		if (numbers == null && length <= 0)
			g_bInputInvalid = true;

		return g_bInputInvalid;
	}

	boolean CheckMoreThanHalf(int[] numbers, int length, int number) {
		int times = 0;
		for (int i = 0; i < length; ++i) {
			if (numbers[i] == number)
				times++;
		}

		boolean isMoreThanHalf = true;
		if (times * 2 <= length) {
			g_bInputInvalid = true;
			isMoreThanHalf = false;
		}

		return isMoreThanHalf;
	}

}
