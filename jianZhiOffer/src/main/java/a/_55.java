package a;

public class _55 {

	/*
	 * ��Ŀ1.����������� 
	 * 
	 * ��Ŀ2.�ж��Ƿ���ƽ�������
	 */
	int TreeDepth(TreeNode pRoot) {
		if (pRoot == null)
			return 0;

		int nLeft = TreeDepth(pRoot.left);
		int nRight = TreeDepth(pRoot.right);

		return (nLeft > nRight) ? (nLeft + 1) : (nRight + 1);
	}

}
