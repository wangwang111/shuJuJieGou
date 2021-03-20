package a;

public class _27 {
	
	/*
	 * ¶þ²æÊ÷µÄ¾µÏñ
	 */

	void MirrorRecursively(TreeNode pNode) {
		if ((pNode == null) || (pNode.left == null && pNode.right == null))
			return;

		TreeNode pTemp = pNode.left;
		pNode.left = pNode.right;
		pNode.right = pTemp;

		if (pNode.left != null)
			MirrorRecursively(pNode.left);

		if (pNode.right != null)
			MirrorRecursively(pNode.right);
	}

}
