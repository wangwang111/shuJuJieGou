package a;

public class _10 {

	/*
	 * ��Ŀһ 쳲�������
	 * 
	 * �õݹ鷽ʽ�������кܶ��ظ��㣬�����ظ��Ľڵ���������n���������������
	 * �õݹ�ķ�ʽ�����ʱ�临�Ӷ���n��ָ���ķ�ʽ����
	 * 
	 * ���ԣ����õ����ķ�ʽ����С���ϼ��㣬��һЩ�Եõ����м��������������һ����Ҫ����������Щ�м���
	 * 
	 * ��Ŀ�� ��̨������
	 */

	// ====================����1���ݹ�====================
	long Fibonacci_Solution1(int n) {
		if (n <= 0)
			return 0;

		if (n == 1)
			return 1;

		return Fibonacci_Solution1(n - 1) + Fibonacci_Solution1(n - 2);
	}

	// ====================����2��ѭ��====================
	static long fib2(int n) {
		int result[]= {0,1};
		if(n<2)
			return result[n];
		
		long fibOne=0;
		long fibTwo=1;
		long fibN=0;
		for(int i=2;i<=n;i++) {
			fibN=fibOne+fibTwo;
			
			fibOne=fibTwo;
			fibTwo=fibN;
		}
		
		return fibN;
	}

}
