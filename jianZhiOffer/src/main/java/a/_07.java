package a;

public class _07 {

	/*
	 * 前序遍历和中序遍历重建二叉树
	 */
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
		return root;
	}

	public TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

		if (startPre > endPre || startIn > endIn) {
			return null;
		}

		TreeNode root = new TreeNode(pre[startPre]);

		/*
		 * startpre+1，指的是前序遍历左子树的开始位置，即前序遍历根节点的下一个节点。i-startin，i指的是中序遍历根节点的位置，
		 * 减去中序遍历开始位置即左子树的长度。所以i-startiin+starpre是前序遍历左子树结束的位置。
		 */

		for (int i = startIn; i < endIn; i++) {
			if (in[i] == pre[startPre]) {
				root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
				root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
			}
		}

		return root;
	}
}
