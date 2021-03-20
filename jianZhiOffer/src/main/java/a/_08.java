package a;

/*
 * 二叉树的下一个节点
 */

public class _08 {

	/*
	 * 最优解
	 * 情况1：
	 * 如果node有右子树，那么后继节点就是右子树上最左边的节点
	 * 	
	 * 情况2：
	 * 如果node没有右子树，那么先看node是不是node父节点的左孩子，
	 * 如果是左孩子，那么此时node非父节点就是node的后继节点，如果是右孩子，就
	 * 向上寻找node的后继节点，如果发现s是p的左孩子，那么节点p就是node节点的后继节点， 
	 * 否则就一直向上移动
	 * 
	 * 情况3
	 * 如果一直向上寻找，都移动到空结点了，还是没有发现node的后继结点，说明node根本 不存在后继结点，
	 * 返回空即可
	 * 
	 */

	TreeNode GetNext(TreeNode pNode) {
		if (pNode == null)
			return null;

		TreeNode pNext = null;
		if (pNode.right != null) {
			TreeNode pRight = pNode.right;
			while (pRight.left != null)
				pRight = pRight.left;

			pNext = pRight;
		} else if (pNode.parent != null) {
			TreeNode pCurrent = pNode;
			TreeNode pParent = pNode.parent;
			while (pParent != null && pCurrent == pParent.right) {
				pCurrent = pParent;
				pParent = pParent.parent;
			}

			pNext = pParent;
		}

		return pNext;
	}

}
