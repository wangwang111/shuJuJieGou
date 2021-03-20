package a;

public class _42 {

	/*
	 * ���������������
	 * 
	 * ���arr���������������ұ���arr���ñ���arr��¼ÿһ�����ۼӺͣ�����������cur����
	 * ����������cur���٣���cur<0��˵���ۼӵ���ǰ������С��0�Ľ��
	 * ��ô�ۼӵ���һ���ֿ϶�������Ϊ��������ۼӺ͵����������߲��֣���ʱ��cur=1����ʾ���´���һ������ʼ�ۼ�
	 * ��cur>0��ÿ���ۼӶ��п����������ۼӺ�
	 * ���ԣ�������һ������maxȫ�̸��ټ�¼cur���ֵ����ֵ����
	 */
	public static int maxSum(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		int res = arr[0];
		int cur = arr[0];

		for (int i = 1; i < arr.length; i++) {
			cur = cur < 0 ? 0 : cur;
			cur = cur + arr[i];
			res = Math.max(res, cur);
		}

		return res;
	}
	
}
