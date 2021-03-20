package a;

public class _04 {

	/*
	 * ��ά����Ĳ���
	 * ʱ�临�Ӷ�O(n+m),�ռ临�Ӷ�O(1)
	 * 
	 * ��ά���飺
	 * �����ҵ��������ϵ��µ���
	 * 
	 * ����ѡȡ���������Ͻ����֣�
	 * ������ڣ����ҽ�����
	 * ������ڲ������֣��޳���һ�У�
	 * ���С�ڣ��޳���һ��
	 * ÿһ����������ֱ���ҵ��ø�����
	 */
	boolean find(int[][] matrix,int target) {
		boolean found=false;
		
		//arr.length�г���,arr[0].length�еĳ��� 
		if(matrix != null && matrix.length >0 && matrix[0].length >0) {
			int row=0;
			int column=matrix[0].length-1;
			while(row <matrix.length && column >= 0) {
				if(matrix[row][column] == target) {
					found=true;
					break;
				}else if(matrix[row][column] > target){
					--column;
				}else {
					++row;
				}
			}
		}
		return found;
	}
	
}