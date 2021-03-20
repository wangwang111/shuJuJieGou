package a;

public class _56 {

	/*
	 * 题目一 
	 * 数组中只出现一次的两个数字 一个整形数组里除了两个数字之外，其他数字都出现了两次 
	 * 时间复杂度O(n)，空间复杂度O(1)
	 * 
	 * 假如：题目都强调一个数字只出现一次， 则：异或运算：任何一个数字的异或它自己都等于0，也就是说，我们从头到尾依次异或数组中
	 * 的每个数字，那么最终的 结果刚好是那个只出现依次的数字
	 * 
	 * 例如：假如输入数组{2,4,3,6,3,2,5,5}，每个数字进行异或运算之后，得到的结果用二进制表示0010，
	 * 异或倒数第二位是1，于是我们更据数字的倒数第二位是不是1，将数组分为两个子数组
	 * 第一个子数组{2,3,6,3,2}中所有数字的倒数第二位都是1，而第二个子数组{4,5,5}中所有数字的第二位都是0
	 * 接下来，只有分别两个子数组求异或，两个数组中只出现一个的数字：6,4
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

	// 找到num从右边数起第一个是1的位
	int FindFirstBitIs1(int num) {
		int indexBit = 0;
		while (((num & 1) == 0) && (indexBit < 8 * 4)) {
			num = num >> 1;
			++indexBit;
		}

		return indexBit;
	}

	// 判断数字num的第indexBit位是不是1
	boolean IsBit1(int num, int indexBit) {
		num = num >> indexBit;
		return (num & 1) == 1;
	}

}
