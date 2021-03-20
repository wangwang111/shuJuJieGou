package a;

import java.util.Stack;

public class _18 {

	/*
	 * ��Ŀһ 
	 * ��O(1)ʱ��ɾ�������� �������������ͷָ���һ�����ָ�룬
	 * ����һ��������O(1)ʱ��ɾ���ýڵ�
	 * ����һ���ڵ�����ݸ��Ƶ���Ҫɾ���Ľڵ��ϣ�����ԭ�е����ݣ��ٰ���һ���ڵ�ɾ��
	 * 
	 *
	 * ��Ŀ���� 
	 * ɾ������ظ�Ԫ��
	 */
	void DeleteNode(ListNode pListHead, ListNode pToBeDeleted) {
		if (pListHead == null || pToBeDeleted == null)
			return;

		// Ҫɾ���Ľ�㲻��β���
		if (pToBeDeleted.next != null) {
			ListNode pNext = pToBeDeleted.next;
			pToBeDeleted.value = pNext.value;
			pToBeDeleted.next = pNext.next;

			pNext = null;
		}
		// ����ֻ��һ����㣬ɾ��ͷ��㣨Ҳ��β��㣩
		else if (pListHead == pToBeDeleted) {
			pToBeDeleted = null;
			pListHead = null;
		}
		// Ҫɾ���Ľڵ�����β��������Ҫ�������ͷ��㿪ʼ��˳������õ��õ��ýڵ��
		// ǰ��ڵ㣬Ȼ��ɾ��
		else {
			ListNode pNode = pListHead;
			while (pNode.next != pToBeDeleted) {
				pNode = pNode.next;
			}

			pNode.next = null;
			pToBeDeleted = null;
		}
	}

	/*
	 * ��Ŀ�� ɾ��������ظ�Ԫ��
	 * ��һ�����������У�ɾ���ظ��ڵ�
	 */
	void DeleteDuplication(ListNode pHead) {
		if (pHead == null || pHead == null)
			return;

		ListNode pPreNode = null;
		ListNode pNode = pHead;
		
		while (pNode != null) {
			ListNode pNext = pNode.next;
			boolean needDelete = false;
			
			if (pNext != null && pNext.value == pNode.value)
				needDelete = true;

			if (!needDelete) {
				pPreNode = pNode;
				pNode = pNode.next;
			} else {
				int value = pNode.value;
				ListNode pToBeDel = pNode;
		
				while (pToBeDel != null && pToBeDel.value == value) {
					pNext = pToBeDel.next;
					pToBeDel = pNext;
				}

				if (pPreNode == null)
					pHead = pNext;
				else
					pPreNode.next = pNext;
				
				pNode = pNext;
			}
		}
	}

}
