package a;

public class _28 {

	/*
	 * ¶Ô³Æ¶þ²æÊ÷
	 */

	boolean isSymmetrical(TreeNode pRoot) {
		return isSymmetrical(pRoot, pRoot);
	}

	private boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2) {
		if (pRoot1 == null && pRoot2 == null)
			return true;

		if (pRoot1 == null || pRoot2 == null)
			return false;

		if (pRoot1.value != pRoot2.value)
			return false;

		return isSymmetrical(pRoot1.left, pRoot2.right) && isSymmetrical(pRoot1.right, pRoot2.left);
	}

}
