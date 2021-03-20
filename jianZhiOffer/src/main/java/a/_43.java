package a;

public class _43 {

	/*
	 * 1~n整数中1出现的次数
	 * 
	 * 每次通过10求余，判断整数的个数是不是1
	 * 
	 * 方法二，优化讲思想
	 */
	int NumberOf1Between1AndN_Solution1(int n) {
		int number = 0;

		for (int i = 1; i <= n; ++i)
			number += NumberOf1(i);

		return number;
	}

	int NumberOf1(int n) {
		int number = 0;
		while (n > 0) {
			if (n % 10 == 1)
				number++;

			n = n / 10;
		}

		return number;
	}

}
