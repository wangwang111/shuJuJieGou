package a;

/*
 * ����������һ���ڵ�
 */

public class _08 {

	/*
	 * ���Ž�
	 * ���1��
	 * ���node������������ô��̽ڵ����������������ߵĽڵ�
	 * 	
	 * ���2��
	 * ���nodeû������������ô�ȿ�node�ǲ���node���ڵ�����ӣ�
	 * ��������ӣ���ô��ʱnode�Ǹ��ڵ����node�ĺ�̽ڵ㣬������Һ��ӣ���
	 * ����Ѱ��node�ĺ�̽ڵ㣬�������s��p�����ӣ���ô�ڵ�p����node�ڵ�ĺ�̽ڵ㣬 
	 * �����һֱ�����ƶ�
	 * 
	 * ���3
	 * ���һֱ����Ѱ�ң����ƶ����ս���ˣ�����û�з���node�ĺ�̽�㣬˵��node���� �����ں�̽�㣬
	 * ���ؿռ���
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
