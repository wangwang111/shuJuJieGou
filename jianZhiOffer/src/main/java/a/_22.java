package a;

public class _22 {

	/*
	 * 链表中倒数第k个节点
	 * 
	 * 两个指针，第一个指针从链表的头指针开始遍历向前走k-1步，第二个指针保持不动
	 * 从第k步开始，第二个指针也开始从链表的头指针开始遍历，
	 * 由于两个指针的距离保持在k-1，当第一个指针到链表的尾结点是，第二个正好走到k个节点
	 */
	ListNode FindKthToTail(ListNode pListHead, int k) {
		if (pListHead == null || k == 0)
			return null;

		ListNode pAhead = pListHead;
		ListNode pBehind = null;

		for (int i = 0; i < k - 1; ++i) {
			if (pAhead.next != null)
				pAhead = pAhead.next;
			else {
				return null;
			}
		}

		pBehind = pListHead;
		while (pAhead.next != null) {
			pAhead = pAhead.next;
			pBehind = pBehind.next;
		}

		return pBehind;
	}

}
