package a;

public class _25 {

	/*
	 * �ϲ��������������
	 * ��������������������ϲ���������ʹ������Ľڵ���Ȼ����
	 */
	
	//�ݹ�
	ListNode Merge(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null)
			return pHead2;
		else if (pHead2 == null)
			return pHead1;

		ListNode pMergedHead = null;

		if (pHead1.value < pHead2.value) {
			pMergedHead = pHead1;
			pMergedHead.next = Merge(pHead1.next, pHead2);
		} else {
			pMergedHead = pHead2;
			pMergedHead.next = Merge(pHead1, pHead2.next);
		}

		return pMergedHead;
	}

}
