package a;

public class _22 {

	/*
	 * �����е�����k���ڵ�
	 * 
	 * ����ָ�룬��һ��ָ��������ͷָ�뿪ʼ������ǰ��k-1�����ڶ���ָ�뱣�ֲ���
	 * �ӵ�k����ʼ���ڶ���ָ��Ҳ��ʼ�������ͷָ�뿪ʼ������
	 * ��������ָ��ľ��뱣����k-1������һ��ָ�뵽�����β����ǣ��ڶ��������ߵ�k���ڵ�
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
