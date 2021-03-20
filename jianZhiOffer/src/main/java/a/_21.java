package a;

/*
 * ��������˳����������λ��ż��ǰ��
 * ������λ��ǰ�벿�֣�ż��λ�ں�벿��
 * 
 * ά������ָ�룬��һ��ָ���ʼ��ʱָ������ĵ�һ�����飬��ָ����ƶ���
 * �ڶ���ָ���ʼ��ʱָ����������һ�����飬��ָ��ǰ�ƶ�
 * ������ָ������֮ǰ����һ��ָ������λ�ڵڶ���ָ���ǰ��
 * �����һ��ָ��ָ���������ż�������ҵڶ���ָ��ָ���������������������������
 */
public class _21 {

	void ReorderOddEven_1(int[] pData) {
		if (pData == null || pData.length == 0)
			return;

		int pBegin = pData[0];
		int pEnd = pData.length - 1;

		while (pBegin < pEnd) {
			// ����ƶ�pBegin��ֱ����ָ��ż��      date/2==0
			while (pBegin < pEnd && (pData[pBegin] & 0x1) != 0)
				pBegin++;

			// ��ǰ�ƶ�pEnd��ֱ����ָ������	  date/2!=0
			while (pBegin < pEnd && (pData[pEnd] & 0x1) == 0)
				pEnd--;

			if (pBegin < pEnd) {
				int temp = pData[pBegin];
				pData[pBegin] = pData[pEnd];
				pData[pEnd] = temp;
			}
		}
	}

}
