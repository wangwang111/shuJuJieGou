package a;

public class _53 {

	/*
	 * ��Ŀһ
	 * ���������������г��ֵĴ���
	 * 
	 * ���ڿ��Ų��ң��ҵ�һ��k�����һ��kλ�ã�����м�Ԫ�ص���k��ǰ���Ԫ��С��k�����ǵ�һ��Ԫ��
	 * 
	 * ��Ŀ�� 
	 * ����Ϊn-1�ĵ������������е��������ֶ���Ψһ�ģ�����ÿ�����ֶ��ڷ�Χ0~n-1��n�������У�
	 * ���ҽ���һ�����ֲ��ڸ������У��ҳ�����
	 *
	 * ���ֲ���
	 * ����м�Ԫ�غ��±���ͬ����һ�ֲ���ֻ��Ҫ�����Ұ��
	 * ����м�Ԫ�ص�ֵ���±겻��ȣ�������ǰ��һ��Ԫ�غ������±���ȣ���ζ������м�Ԫ�ص����������ǵ�һ��ֵ���±겻��ȵ�Ԫ��
	 * ����м�Ԫ�ص�ֵ���±겻��ȣ�������ǰ��һ��Ԫ�غ������±겻��ȣ�����ζ����һ�ֲ������Ԫ��
	 * 
	 * ��Ŀ��
	 * ��������ֵ���±���ȵ�Ԫ��
	 * �����������������ÿ��Ԫ�ض�������������Ψһ�ģ��ҳ�����������һ����ֵ�������±�Ԫ��
	 * 
	 * ���������е����֣�ʱ�临�Ӷ�O(n)
	 * 
	 * ��������������ʹ�ö��ֲ���
	 * �������ĵ�i��Ԫ�غ��±���ȣ����ҵ���һ�����ֺ����±����
	 * �������m�����±꣬��߲���
	 * �������mС���±꣬�ұ߲���
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

	// �ҵ������е�һ��k���±ꡣ��������в�����k������-1
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

	// �ҵ����������һ��k���±ꡣ��������в�����k������-1
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

	
	// ==============================��Ŀ��===========================

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

		// ��Ч�����룬�������鲻�ǰ�Ҫ������ģ�
		// ���������ֲ���0��n-1��Χ֮��
		return -1;
	}

	
	
	// ==============================��Ŀ��===========================
	
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
