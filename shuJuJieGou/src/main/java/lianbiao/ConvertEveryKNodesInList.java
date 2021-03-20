package lianbiao;

import java.util.Stack;

public class ConvertEveryKNodesInList {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	/*
	 * 时间O(n),额外空间O(n)
	 */
	public static Node reverseKNodes1(Node head, int K) {
		if (K < 2) {
			return head;
		}
		Stack<Node> stack = new Stack<Node>();
		Node newHead = head;
		Node cur = head;
		Node pre = null;
		Node next = null;
		while (cur != null) {
			next = cur.next;
			stack.push(cur);
			if (stack.size() == K) {
				// 纪录之前组的坐标
				pre = resign1(stack, pre, next);
				// 纪录调整之后结点
				newHead = newHead == head ? cur : newHead;
			}
			cur = next;
		}
		// 返回调整之后的节点
		return newHead;
	}

	public static Node resign1(Stack<Node> stack, Node left, Node right) {
		Node cur = stack.pop();
		if (left != null) {
			left.next = cur;
		}
		Node next = null;
		while (!stack.isEmpty()) {
			next = stack.pop();
			cur.next = next;
			cur = next;
		}
		cur.next = right;
		return cur;
	}

	/*
	 * 最优解:
	 * 
	 * 时间O(n),额外空间O(1)
	 */
	public static Node reverseKNodes2(Node head, int K) {
		if (K < 2) {
			return head;
		}
		Node cur = head;
		Node start = null;
		Node pre = null;
		Node next = null;
		int count = 1;
		while (cur != null) {
			next = cur.next;
			if (count == K) {
				start = pre == null ? head : pre.next;
				head = pre == null ? cur : head;
				resign2(pre, start, cur, next);
				pre = start;
				count = 0;
			}
			count++;
			cur = next;
		}
		return head;
	}

	public static void resign2(Node left, Node start, Node end, Node right) {
		Node pre = start;
		Node cur = start.next;
		Node next = null;
		while (cur != right) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		if (left != null) {
			left.next = end;
		}
		start.next = right;
	}

	public static void printLinkedList(Node head) {
		System.out.print("Linked List: ");
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}

}
