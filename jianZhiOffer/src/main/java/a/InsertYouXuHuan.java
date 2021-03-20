package a;

public class InsertYouXuHuan {

	/*
	 * 向有序环中插入元素
	 * 1.如果链表为空，让链表自己实现环形链表
	 * 2.链表不为空，pre指向head结点，cur指向下一个节点
	 * 		然后同步移动，如果遇到p.val<node.val<c.val,则插入p和c之间
	 * 3.如果p和c转一圈都没有发现应该插入的位置，此时应该插入头结点的前面
	 */
	
	public static Node insertNum(Node head, int num) {
		Node node = new Node(num);
		if (head == null) {
			node.next = node;
			return node;
		}
		
		Node pre = head;
		Node cur = head.next;
		while (cur != head) {
			if (pre.value <= num && num <= cur.value ) {
				break;
			}
			pre = cur;
			cur = cur.next;
		}
		pre.next = node;
		node.next = cur;
		return head.value < num ? head : node;
	}


	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

}
