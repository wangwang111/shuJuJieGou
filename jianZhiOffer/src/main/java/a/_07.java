package a;

public class _07 {

	/*
	 * ǰ���������������ؽ�������
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
		 * startpre+1��ָ����ǰ������������Ŀ�ʼλ�ã���ǰ��������ڵ����һ���ڵ㡣i-startin��iָ��������������ڵ��λ�ã�
		 * ��ȥ���������ʼλ�ü��������ĳ��ȡ�����i-startiin+starpre��ǰ�����������������λ�á�
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
