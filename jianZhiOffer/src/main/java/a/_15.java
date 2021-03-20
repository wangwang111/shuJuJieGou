package a;

public class _15 {

	/*
	 * 二进制中1的个数
	 * 
	 * 把一个整数减去1，都是把最右边的1变成0，
	 * 如果它的右边还有0，则所有的0都变成1，而它左边的所有位都保持不变
	 * 接下来，把一个整数和它减1的结果做位运算，相当于把右边1都变成0
	 */
	static int NumberOf1_Solution(int n) {
		int count = 0;

		while (n != 0) {
			++count;
			n = (n - 1) & n;
		}

		return count;
	}

}