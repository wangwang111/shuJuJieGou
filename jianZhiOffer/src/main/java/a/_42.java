package a;

public class _42 {

	/*
	 * 连续子数组的最大和
	 * 
	 * 如果arr中有正数，从左到右遍历arr，用变量arr纪录每一步的累加和，遍历到正数cur增加
	 * 遍历到负数cur减少，当cur<0，说明累加到当前出现了小于0的结果
	 * 那么累加的这一部分肯定不能作为产生最大累加和的子数组的左边部分，此时另cur=1，表示重新从下一个数开始累加
	 * 当cur>0，每次累加都有可能是最大的累加和
	 * 所以，用另外一个变量max全程跟踪记录cur出现的最大值即可
	 */
	public static int maxSum(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		int res = arr[0];
		int cur = arr[0];

		for (int i = 1; i < arr.length; i++) {
			cur = cur < 0 ? 0 : cur;
			cur = cur + arr[i];
			res = Math.max(res, cur);
		}

		return res;
	}
	
}
