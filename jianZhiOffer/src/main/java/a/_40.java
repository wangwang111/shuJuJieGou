package a;

public class _40 {

	/*
	 * 最小的k个数
	 * 基于快排
	 */
	int Partition(int[] input, int begin, int end) {

		int low = begin;
		int high = end;

		int pivot = input[low];
		while (low != high) {
			while (low < high && pivot <= input[high])
				high--;
			input[low] = input[high];
			while (low < high && pivot >= input[low])
				low++;
			input[high] = input[low];
		}
		input[low] = pivot;
		return low;
	}

	int[] GetLeastNumbers_Solution1(int[] input, int k) {
		int len = input.length;

		if (len == 0 || k > len)
			return input;

		int start = 0;
		int end = len - 1;
		int index = Partition(input, start, end);
		while (index != k - 1) {
			if (index > k - 1) {
				end = index - 1;
				index = Partition(input, start, end);
			} else {
				start = index + 1;
				index = Partition(input, start, end);
			}
		}

		int[] output = new int[k];
		for (int i = 0; i < k; ++i)
			output[i] = input[i];
		return output;
	}

}
