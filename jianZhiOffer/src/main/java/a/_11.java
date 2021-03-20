package a;

public class _11 {

	/*
	 * ��ת��������Сֵ
	 * ����һ����������������һ����ת�������ת��ת�������СԪ��
	 * 
	 * �����ͷ����ʱ�临�Ӷ�O(n)�����ö��ֲ��ң�ʱ�临�Ӷ�O(log2^2N)
	 * 
	 * ������һ���̶���������ģ����Բ��ö��ֲ��ҷ�
	 * ������ָ��ֱ�ָ������ĵ�һ��Ԫ�غ����һ��Ԫ�أ�����һ��Ԫ��Ӧ���Ǵ��ڻ��ߵ������һ��
	 * Ԫ�صģ�����������
	 * 
	 * ȡ�����м��Ԫ��
	 * 1.������м�Ԫ�ش��ڻ��ߵ��ڵĸ�ָ�룬��һ��ָ��ָ����м�Ԫ��
	 * 2.������м�Ԫ��С�ڻ��ߵ��ڵĸ�ָ�룬�ڶ���ָ��ָ����м�Ԫ��
	 * 
	 * ѭ���������������ջ�ָ���������ڵ�Ԫ�أ����ڶ���ָ��ָ��ĸպ�����С��Ԫ��
	 * 
	 * ������
	 * 1, 1, 1, 0, 1
	 * ���ò�����˳�����
	 */
	int findMin(int[] arr) {
		if (arr == null || arr.length <= 0)
			throw new RuntimeException("Invalid parameters");

		int low = 0;
		int high = arr.length - 1;
		int mid = low;
		while (arr[low] >= arr[high]) {
			// ���low��highָ�����ڵ���������
			// ��lowָ���һ����������������һ�����֣�
			// highָ��ڶ���������ĵ�һ�����֣�Ҳ���������е���С����
			if (high - low == 1) {
				mid = high;
				break;
			}

			// ����±�Ϊlow��high��midָ�������������ȣ�
			// ��ֻ��˳�����
			mid = low + (high - low) / 2;
			if (arr[low] == arr[high] && arr[mid] == arr[low])
				return minInOrder(arr, low, high);

			/*
			 * �Ͷ��ֲ���һ��������������ָ��ָ������ĵ�һ��Ԫ�غ����һ��Ԫ�أ�
			 * ��һ��Ԫ��Ӧ�ô��ڻ�������һ��Ԫ�أ�����������
			 * 
			 * �����м�Ԫ�أ�
			 * ������м�Ԫ��λ��ǰ��ĵ��������飬��ô��Ӧ�ô��ڻ���ڵ�һ��ָ���Ԫ�ء�
			 * ��ʱ��������СԪ��Ӧ��λ���м�Ԫ�صĺ��棬�ѵ�һ��ָ��ָ���м�Ԫ��
			 * 
			 * ����м�Ԫ��λ�ں���ĵ��������У���ô��Ӧ��С�ڻ��ߵ��ڵڶ���ָ��ָ��Ԫ�أ�
			 * ��ô��СԪ��Ӧ��λ��ǰ�棬�ѵڶ���ָ��ָ���м�Ԫ��
			 */
			// ��С���ҷ�Χ
			if (arr[mid] >= arr[low])
				low = mid;
			else if (arr[mid] <= arr[high])
				high = mid;
		}

		return arr[mid];
	}

	int minInOrder(int[] arr, int low, int high) {
		int result = arr[low];
		for (int i = low + 1; i <= high; ++i) {
			if (result > arr[i])
				result = arr[i];
		}

		return result;
	}

	
	public static void main(String[] args) {
		_11 a=new _11();
		int i=a.findMin(new int[] {3,4,5,2,3});
		System.out.println(i);
	}
}