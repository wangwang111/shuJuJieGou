package a;

public class _43 {

	/*
	 * 1~n������1���ֵĴ���
	 * 
	 * ÿ��ͨ��10���࣬�ж������ĸ����ǲ���1
	 * 
	 * ���������Ż���˼��
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
