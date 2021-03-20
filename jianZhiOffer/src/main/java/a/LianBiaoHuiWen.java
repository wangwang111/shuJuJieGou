package a;

import java.util.Stack;

public class LianBiaoHuiWen {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	/*
	 * 判断链表是否为回文结构
	 * 
	 * 1.栈压入然后比较,空间复杂度O(n) 
	 * 2.快指针走2步，慢指针1步，栈弹出，对比慢指针，空间复杂度O(n/2)
	 */
	public static boolean isPalindrome1(Node head) {
		Stack<Node> stack = new Stack<Node>();
		Node cur = head;
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		while (head != null) {
			if (head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

}
