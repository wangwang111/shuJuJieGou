package a;

public class _57 {

	/*
	 * ��Ŀһ 
	 * ��Ϊs������
	 * ��������������һ������s���������в�����������ʹ�����Ǻ�������s������ж�Ժ͵���s�����������һ��
	 * 
	 * �����������ѡ���������֣�������ǵĺ͵��������s����ô���Ǿ�������������
	 * �����С��s������ϣ���������ڴ�һ�㣬���������ѽ��ź����ˣ��ý�С����������ƶ�
	 * ����ʹ���s������ϣ����������Сһ�㣬�ýϴ�����������ƶ�
	 * 
	 * ��������ָ�룬��һ��ָ��ָ������ĵ�һ�����飬�ڶ���ָ��ָ����������һ������
	 * ����ʹ���s���ڶ���ָ�������ƶ�һ������
	 * �����С��s����һ��ָ�������ƶ�һ������
	 * 
	 * 
	 * ��Ŀ��
	 * ��Ϊs��������������
	 * ����һ������s����ӡ���к�Ϊs�������������У�
	 * ���磺15
	 * 1+2+3+4+5  =  4+5+6  =  7+8
	 * ��ӡ1~5��4~6,7~8 
	 * 
	 * ������small��big�ֱ��ʾ���е���Сֵ�����ֵ��
	 * small��ʼֵ1��big��ʼֵ2
	 * ��small��big���еĺʹ���s������Դ�������ȥ����С��ֵ��������small
	 * ��small��big���еĺ�С��s��������big
	 * һֱ���ӵ�small�� (1+s)/2  Ϊֹ
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
