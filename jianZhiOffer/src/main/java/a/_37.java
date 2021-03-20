package a;

import java.util.LinkedList;
import java.util.Queue;

public class _37 {

	/*
	 * ���л�������
	 */
	
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	/*
	 * 1.�������л����Ϊstr����ʼ��ʱΪ���ַ���
	 * 2.�������������ʱ����������ս�㣬��strĩβ���ϡ�#!��
	 * 3.��Ϊ�գ�������Ϊ3����strĩβ���ϡ�3!��
	 */
	public static String serialByPre(Node head) {
		if (head == null) {
			return "#!";
		}
		String res = head.value + "!";
		res += serialByPre(head.left);
		res += serialByPre(head.right);
		return res;
	}

	public static Node reconByPreString(String preStr) {
		String[] values = preStr.split("!");
		Queue<String> queue = new LinkedList<String>();
		for (int i = 0; i != values.length; i++) {
			queue.offer(values[i]);
		}
		return reconPreOrder(queue);
	}

	public static Node reconPreOrder(Queue<String> queue) {
		String value = queue.poll();
		if (value.equals("#")) {
			return null;
		}
		Node head = new Node(Integer.valueOf(value));
		head.left = reconPreOrder(queue);
		head.right = reconPreOrder(queue);
		return head;
	}

}
