package a;

public class _56 {

	/*
	 * ��Ŀһ 
	 * ������ֻ����һ�ε��������� һ�����������������������֮�⣬�������ֶ����������� 
	 * ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(1)
	 * 
	 * ���磺��Ŀ��ǿ��һ������ֻ����һ�Σ� ��������㣺�κ�һ�����ֵ�������Լ�������0��Ҳ����˵�����Ǵ�ͷ��β�������������
	 * ��ÿ�����֣���ô���յ� ����պ����Ǹ�ֻ�������ε�����
	 * 
	 * ���磺������������{2,4,3,6,3,2,5,5}��ÿ�����ֽ����������֮�󣬵õ��Ľ���ö����Ʊ�ʾ0010��
	 * ������ڶ�λ��1���������Ǹ������ֵĵ����ڶ�λ�ǲ���1���������Ϊ����������
	 * ��һ��������{2,3,6,3,2}���������ֵĵ����ڶ�λ����1�����ڶ���������{4,5,5}���������ֵĵڶ�λ����0
	 * ��������ֻ�зֱ��������������������������ֻ����һ�������֣�6,4
	 *  
	 */

	void FindNumsAppearOnce(int data[], int[] num1, int[] num2) {
		if (data == null || data.length < 2)
			return;

		int resultExclusiveOR = 0;
		for (int i = 0; i < data.length; ++i)
			resultExclusiveOR ^= data[i];

		int indexOf1 = FindFirstBitIs1(resultExclusiveOR);

		for (int j = 0; j < data.length; ++j) {
			if (IsBit1(data[j], indexOf1))
				num1[0] ^= data[j];
			else
				num2[0] ^= data[j];
		}
	}

	// �ҵ�num���ұ������һ����1��λ
	int FindFirstBitIs1(int num) {
		int indexBit = 0;
		while (((num & 1) == 0) && (indexBit < 8 * 4)) {
			num = num >> 1;
			++indexBit;
		}

		return indexBit;
	}

	// �ж�����num�ĵ�indexBitλ�ǲ���1
	boolean IsBit1(int num, int indexBit) {
		num = num >> indexBit;
		return (num & 1) == 1;
	}

}
