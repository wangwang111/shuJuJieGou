package erchashu;

import java.util.LinkedList;


import java.util.Queue;

public class IsBSTAndCBT {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	
	/*
	 * 搜索二叉树按中序遍历得到的序列，一定从大到小的排列
	 * 
	 * 1.改写二叉树的中序遍历
	 * 2.遍历到每个结点的值，如果一直比上一个结点值大，是，否则，不是
	 * 3.为了方便同时得到当前结点和上一个结点，非递归合适
	 */
	public static boolean isBST(Node head) {
		if (head == null) {
			return true;
		}
		boolean res = true;
		Node pre = null;
		Node cur1 = head;
		Node cur2 = null;
		while (cur1 != null) {
			cur2 = cur1.left;
			if (cur2 != null) {
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;
				}
				if (cur2.right == null) {
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				} else {
					cur2.right = null;
				}
			}
			if (pre != null && pre.value > cur1.value) {
				res = false;
			}
			pre = cur1;
			cur1 = cur1.right;
		}
		return res;
	}

	/*
	 * 判读是否为完全二叉树
	 * 
	 * 1.按层遍历二叉树方式
	 * 2.如果当前结点有右孩子，但是没有左孩子，直接返回false
	 * 3.如果当前结点并不是左右孩子全有，之后的节点必须叶节点，否则false
	 * 4.遍历过程不返回false，则true
	 */
	public static boolean isCBT(Node head) {
		if (head == null) {
			return true;
		}
		Queue<Node> queue = new LinkedList<Node>();
		boolean leaf = false;			//leaf表示阶段切换
		Node l = null;
		Node r = null;
		queue.offer(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			l = head.left;
			r = head.right;
			//leaf && (l != null || r != null)当前是叶节点阶段
			if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
				return false;
			}
			if (l != null) {
				queue.offer(l);
			}
			if (r != null) {
				queue.offer(r);
			} else {
				leaf = true;
			}
		}
		return true;
	}

}
