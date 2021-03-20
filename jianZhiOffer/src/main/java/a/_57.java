package a;

public class _57 {

	/*
	 * 题目一 
	 * 和为s的数字
	 * 递增排序的数组和一个数字s，在数组中查找两个数，使得它们和正好是s，如果有多对和等于s，则输出任意一对
	 * 
	 * 先在数组汇总选择两个数字，如果它们的和等于输入的s，那么我们就扎到这两个数
	 * 如果和小于s，我们希望两个数在大一点，由于数组已将排好序了，让较小的数字向后移动
	 * 如果和大于s，我们希望两个数在小一点，让较大的数字向左移动
	 * 
	 * 定义两个指针，第一个指针指向数组的第一个数组，第二个指针指向数组的最后一个数字
	 * 如果和大于s，第二个指针向左移动一个数字
	 * 如果和小于s，第一个指针向右移动一个数字
	 * 
	 * 
	 * 题目二
	 * 和为s的连续正数序列
	 * 输入一个正数s，打印所有和为s的连续正数序列，
	 * 例如：15
	 * 1+2+3+4+5  =  4+5+6  =  7+8
	 * 打印1~5，4~6,7~8 
	 * 
	 * 两个数small和big分别表示序列的最小值和最大值，
	 * small初始值1，big初始值2
	 * 从small到big序列的和大于s，则可以从序列中去掉较小的值，即增大small
	 * 从small到big序列的和小于s，则增大big
	 * 一直增加到small到 (1+s)/2  为止
	 */

	boolean FindNumbersWithSum(int data[], int length, int sum, int num1, int num2) {
		boolean found = false;
		if (length < 1)
			return found;

		int ahead = length - 1;
		int behind = 0;

		while (ahead > behind) {
			long curSum = data[ahead] + data[behind];

			if (curSum == sum) {
				num1 = data[behind];
				num2 = data[ahead];
				found = true;
				break;
			} else if (curSum > sum)
				ahead--;
			else
				behind++;
		}

		return found;
	}

	void FindContinuousSequence(int sum) {
		if (sum < 3)
			return;

		int small = 1;
		int big = 2;
		int middle = (1 + sum) / 2;
		int curSum = small + big;

		while (small < middle) {
			if (curSum == sum)
				PrintContinuousSequence(small, big);

			while (curSum > sum && small < middle) {
				curSum -= small;
				small++;

				if (curSum == sum)
					PrintContinuousSequence(small, big);
			}

			big++;
			curSum += big;
		}
	}

	void PrintContinuousSequence(int small, int big) {
		for (int i = small; i <= big; ++i)
			System.out.println("i ");

		System.out.println();
	}

}
