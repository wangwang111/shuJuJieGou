package a;

/*
 * ����ĸ���
 */
public class _35 {

	static class ListNode {
		int value;
		ListNode next, pSibling;
	}

	/*
	 * ����ԭʼ�����������N�������½ڵ�N������N�����ӵ�N�ĺ���
	 */
	void CloneNodes(ListNode pHead) {
		ListNode pNode = pHead;
		while (pNode != null) {
			ListNode pCloned = new ListNode();
			pCloned.value = pNode.value;
			pCloned.next = pNode.next;
			pCloned.pSibling = null;

			pNode.next = pCloned;

			pNode = pCloned.next;
		}
	}

	//���Ƴ����Ľڵ�m_pSibing
	void ConnectSiblingNodes(ListNode pHead) {
		ListNode pNode = pHead;
		while (pNode != null) {
			ListNode pCloned = pNode.next;
			if (pNode.pSibling != null) {
				pCloned.pSibling = pNode.pSibling.next;
			}

			pNode = pCloned.next;
		}
	}

	//��������������
	ListNode ReconnectNodes(ListNode pHead) {
		ListNode pNode = pHead;
		ListNode pClonedHead = null;
		ListNode pClonedNode = null;

		if (pNode != null) {
			pClonedHead = pClonedNode = pNode.next;
			pNode.next = pClonedNode.next;
			pNode = pNode.next;
		}

		while (pNode != null) {
			pClonedNode.next = pNode.next;
			pClonedNode = pClonedNode.next;

			pNode.next = pClonedNode.next;
			pNode = pNode.next;
		}

		return pClonedHead;
	}

}
