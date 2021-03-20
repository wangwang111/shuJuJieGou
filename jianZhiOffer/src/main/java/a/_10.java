package a;

public class _10 {

	/*
	 * 题目一 斐波拿契列
	 * 
	 * 用递归方式，发现有很多重复点，而且重复的节点数会随着n的增大而急剧增大，
	 * 用递归的方式计算的时间复杂度以n的指数的方式递增
	 * 
	 * 所以，采用迭代的方式，从小往上计算，把一些以得到的中间项保存起来，在下一次需要计算利用这些中间项
	 * 
	 * 题目二 跳台阶问题
	 */

	// ====================方法1：递归====================
	long Fibonacci_Solution1(int n) {
		if (n <= 0)
			return 0;

		if (n == 1)
			return 1;

		return Fibonacci_Solution1(n - 1) + Fibonacci_Solution1(n - 2);
	}

	// ====================方法2：循环====================
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
