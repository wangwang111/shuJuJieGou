package a;

public class _55 {

	/*
	 * 题目1.二叉树的深度 
	 * 
	 * 题目2.判断是否是平衡二叉树
	 */
	int TreeDepth(TreeNode pRoot) {
		if (pRoot == null)
			return 0;

		int nLeft = TreeDepth(pRoot.left);
		int nRight = TreeDepth(pRoot.right);

		return (nLeft > nRight) ? (nLeft + 1) : (nRight + 1);
	}

}
