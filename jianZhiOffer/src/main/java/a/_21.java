package a;

/*
 * 调整数组顺序是奇数都位于偶数前面
 * 奇数都位于前半部分，偶数位于后半部分
 * 
 * 维护两个指针，第一个指针初始化时指向数组的第一个数组，它指向后移动，
 * 第二个指针初始化时指向数组的最后一个数组，它指向前移动
 * 在两个指针相遇之前，第一个指针总是位于第二个指针的前面
 * 如果第一个指针指向的数字是偶数，并且第二个指针指向的数字是奇数，交换两个数字
 */
public class _21 {

	void ReorderOddEven_1(int[] pData) {
		if (pData == null || pData.length == 0)
			return;

		int pBegin = pData[0];
		int pEnd = pData.length - 1;

		while (pBegin < pEnd) {
			// 向后移动pBegin，直到它指向偶数      date/2==0
			while (pBegin < pEnd && (pData[pBegin] & 0x1) != 0)
				pBegin++;

			// 向前移动pEnd，直到它指向奇数	  date/2!=0
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
