package a;

import java.util.ArrayList;

public class _34 {

	/*
	 * �������к�ĳһֵ��·��
	 * �ο�ţ�ʹ���
	 */
	private ArrayList<ArrayList<Integer>> listAll=new ArrayList<>();
	private ArrayList<Integer> list=new ArrayList<>();
	
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target){
		if(root==null) {
			return listAll;
		}
		
		target-=root.value;
		if(target==0 && root.left==null && root.right==null)
			listAll.add(new ArrayList<Integer>(list));
		
		FindPath(root.left, target);
		FindPath(root.right, target);
		list.remove(list.size());
		return listAll;
	}
}
