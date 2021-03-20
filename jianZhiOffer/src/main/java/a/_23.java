package a;

import java.util.HashMap;

public class _23 {

	/*
	 * �����л�����ڽڵ�
	 * 
	 * ����һ��hash��
	 */
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		ListNode node = pHead;

		HashMap<ListNode, Boolean> map = new HashMap<>();

		while (node != null) {
			if (map.containsKey(node)) {
				return node;
			} else {
				map.put(node, true);
				node = node.next;
			}
		}
		return null;
	}

	/*
	 * ��ָ����1������ָ��2�� 
	 * ��������
	 * ��ָ�뿪ͷ����ͷ��1�� 
	 * ��������ͷ���
	 * 
	 * ʱ��O(n),�ռ�O(1)
	 */
	public int chkLoop2(ListNode head, int adjust) {
		if (head == null)
			return -1;
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}
		if (fast.next == null || fast.next.next == null)
			return -1;

		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return fast.value;
	}

}
