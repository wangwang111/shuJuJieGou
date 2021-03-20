package a;

import java.util.Stack;

public class LianBiao_K_nixu {

	
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	/*
	 * 链表k个之间逆序
	 * 1.用栈处理
	 *  
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
				pre = resign1(stack, pre, next);
				newHead = newHead == head ? cur : newHead;
			}
			cur = next;
		}
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
}

