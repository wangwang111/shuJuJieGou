package a;

public class _54 {

	/*
	 * 二叉搜索数=、第k大节点 中序遍历
	 */

	TreeNode KthNode(TreeNode pRoot, int k) {
		if (pRoot == null || k == 0)
			return null;

		return KthNodeCore(pRoot, k);
	}

	TreeNode KthNodeCore(TreeNode pRoot, int k) {
		TreeNode target = null;

		if (pRoot.left != null)
			target = KthNodeCore(pRoot.left, k);

		if (target == null) {
			if (k == 1)
				target = pRoot;

			k--;
		}

		if (target == null && pRoot.right != null)
			target = KthNodeCore(pRoot.right, k);

		return target;
	}

}
