package a;

import java.util.LinkedList;
import java.util.Queue;

public class _36 {

	/*
	 * 二叉搜索树与双向链表
	 *  1.队列 2.
	 */

	public static TreeNode convert1(TreeNode head) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		// 中序遍历
		inOrderToQueue(head, queue);
		if (queue.isEmpty()) {
			return head;
		}

		head = queue.poll();

		TreeNode pre = head;
		pre.left = null;
		TreeNode cur = null;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			pre.right = cur;
			cur.left = pre;
			pre = cur;
		}

		pre.right = null;
		return head;
	}

	private static void inOrderToQueue(TreeNode head, Queue<TreeNode> queue) {
		if (head == null)
			return;

		inOrderToQueue(head.left, queue);
		queue.offer(head);
		inOrderToQueue(head.right, queue);
	}

}
