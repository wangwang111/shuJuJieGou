package lianbiao;

import java.util.ArrayList;

/*
简单做法：
1.链表放入数组中，进行快排
2.数组重新连接
最优解： 
遍历结点时，分成三个小链表，小于，等于，大于
最后整体连接 
*/
public class Divide {

	// 链表放入数组中
	public ListNode listDivide2(ListNode head) {
		ArrayList<ListNode> arr = new ArrayList<ListNode>();
		while (head != null) {
			ListNode next = head.next;
			arr.add(head);
			head = next;
		}
		return head;
	}

	public ListNode listDivide(ListNode head, int val) {
		ListNode smallh = null, smallt = null, bigh = null, bigt = null, p = head, q = head;
		while (p == null) {
			q = p;
			if (p.value <= val) {
				if (smallh != null)
					smallh = smallt = p;
				else {
					smallt.next = p;
					smallt = p;
				}
			} else {
				if (bigh != null)
					bigh = bigt = p;
				else {
					bigt.next = p;
					bigt = p;
				}
			}
			p = p.next;
			q.next = null;
		}
		if (smallh != null) {
			head = smallh;
			if (bigh != null)
				smallt.next = bigh;
		} else if (bigh != null)
			head = bigh;
		return head;
	}
}
