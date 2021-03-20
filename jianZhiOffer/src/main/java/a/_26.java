package a;

public class _26 {

	/*
	 * 树的子树
	 * 
	 * 遍历二叉树，然后kmp
	 */
	boolean HasSubtree(TreeNode pRoot1, TreeNode pRoot2) {
		boolean result = false;

		if (pRoot1 != null && pRoot2 != null) {
			if (Equal(pRoot1.value, pRoot2.value))
				result = DoesTree1HaveTree2(pRoot1, pRoot2);
			if (!result)
				result = HasSubtree(pRoot1.left, pRoot2);
			if (!result)
				result = HasSubtree(pRoot1.right, pRoot2);
		}

		return result;
	}

	boolean DoesTree1HaveTree2(TreeNode pRoot1, TreeNode pRoot2) {
		if (pRoot2 == null)
			return true;

		if (pRoot1 == null)
			return false;

		if (!Equal(pRoot1.value, pRoot2.value))
			return false;

		return DoesTree1HaveTree2(pRoot1.left, pRoot2.left) && DoesTree1HaveTree2(pRoot1.right, pRoot2.right);
	}

	boolean Equal(double num1, double num2) {
		if ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001))
			return true;
		else
			return false;
	}

}
