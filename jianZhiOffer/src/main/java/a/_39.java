package a;

public class _39 {

	/*
	 * �����г��ִ�������һ�������
	 * 
	 * ����õ����֣�������ͳ��ÿ�����ֳ��ֵĴ���������ʱ�临�Ӷ�O(log^2)
	 * 
	 * �Ż�:
	 * ʱ�临�Ӷ�O(log^2)
	 * �������м�λ�õ�Ԫ��һ���������г��ִ�������һ�������
	 * ���ÿ��ţ����ѡһ�����֣�Ȼ����������е�˳��
	 * ���������ֵ��±�պ���n/2����ô������־�����λ����
	 * ��������±����n/2����λ�����������
	 * ��������±�С��n/2����λ���������ұ�
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
		temp = numbers[s]; // ������ĵ�һ����¼��Ϊ��׼
		while (i != j) { // �����˽������м�ɨ�裬ֱ��i=jΪֹ
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
