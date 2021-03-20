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
	 * �ж������Ƿ�Ϊ���Ľṹ
	 * 
	 * 1.ջѹ��Ȼ��Ƚ�,�ռ临�Ӷ�O(n) 
	 * 2.��ָ����2������ָ��1����ջ�������Ա���ָ�룬�ռ临�Ӷ�O(n/2)
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
