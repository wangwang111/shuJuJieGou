package erchashu;
/*
 * 判断是否为平衡二叉树
 * 
 * 1.左子树是否为平衡二叉树
 * 2.左子树最深到那一层,LH
 * 3.右子树是否为平衡二叉树
 * 4.右子树最深到那一层,RH
 * 5.如果左子树和右平衡二叉树，比较LH和RH
 */
public class IsBalancedTree {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static boolean isBalance(Node head) {
		boolean[] res = new boolean[1];
		res[0] = true;
		getHeight(head, 1, res);
		return res[0];
	}

	//解法整体为二叉树的后续遍历
	public static int getHeight(Node head, int level, boolean[] res) {
		if (head == null) {
			return level;
		}
		int lH = getHeight(head.left, level + 1, res);
		if (!res[0]) {
			return level;
		}
		int rH = getHeight(head.right, level + 1, res);
		if (!res[0]) {
			return level;
		}
		if (Math.abs(lH - rH) > 1) {
			res[0] = false;
		}
		return Math.max(lH, rH);
	}

}
	