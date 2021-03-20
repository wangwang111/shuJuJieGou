package lianbiao;

import java.util.HashMap;

public class ChkLoop {

	/*
	 * 方法一：hash表
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
	 * 慢指针走1步，快指针2步 相遇环中 快指针开头从新走走1步 在相遇环头结点
	 * 
	 * 时间O(n),空间O(1)
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
