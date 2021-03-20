package a;

/*
 * 链表的复制
 */
public class _35 {

	static class ListNode {
		int value;
		ListNode next, pSibling;
	}

	/*
	 * 复制原始链表的任意结点N并创建新节点N·，把N·链接到N的后面
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

	//复制出来的节点m_pSibing
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

	//链表拆成两个链表
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
