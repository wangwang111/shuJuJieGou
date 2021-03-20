package a;

public class _04 {

	/*
	 * 二维数组的查找
	 * 时间复杂度O(n+m),空间复杂度O(1)
	 * 
	 * 二维数组：
	 * 从左到右递增，从上到下递增
	 * 
	 * 首先选取数组中右上角数字，
	 * 如果等于，查找结束，
	 * 如果大于查找数字，剔除这一列，
	 * 如果小于，剔除这一行
	 * 每一步都这样，直到找到该该数字
	 */
	boolean find(int[][] matrix,int target) {
		boolean found=false;
		
		//arr.length行长度,arr[0].length列的长度 
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