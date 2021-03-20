package a;

import java.util.Stack;

public class _18 {

	/*
	 * 题目一 
	 * 在O(1)时间删除链表结点 给定单向链表的头指针和一个结点指针，
	 * 定义一个函数在O(1)时间删除该节点
	 * 把下一个节点的内容复制到需要删除的节点上，覆盖原有的内容，再把下一个节点删除
	 * 
	 *
	 * 题目二： 
	 * 删除结点重复元素
	 */
	void DeleteNode(ListNode pListHead, ListNode pToBeDeleted) {
		if (pListHead == null || pToBeDeleted == null)
			return;

		// 要删除的结点不是尾结点
		if (pToBeDeleted.next != null) {
			ListNode pNext = pToBeDeleted.next;
			pToBeDeleted.value = pNext.value;
			pToBeDeleted.next = pNext.next;

			pNext = null;
		}
		// 链表只有一个结点，删除头结点（也是尾结点）
		else if (pListHead == pToBeDeleted) {
			pToBeDeleted = null;
			pListHead = null;
		}
		// 要删除的节点链表尾部，则需要从链表的头结点开始，顺序遍历得到得到该节点的
		// 前序节点，然后删除
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
	 * 题目二 删除链表的重复元素
	 * 在一个排序链表中，删除重复节点
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
