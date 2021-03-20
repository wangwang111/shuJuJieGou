package a;

public class _48 {

	/*
	 * 最长不含重复字符的子字符串
	 * 时间复杂度O(n),空间复杂度O(n)
	 * 
	 * 依次求出以每个字符位置的向左最远最长无重复子串，其中最大值就是最长无重复子串
	 * 
	 * 假设求i位置最长无重复子串的长度,需要两个变量
	 *
	 * 1.哈希表map  -->其中统计了每种字符之前出现的位置
	 * 2.整形pre   -->  代表以s[i-1]结尾的情况下，最长无重复子串的长度
	 * 
	 * map中key表示某个字符，value为这个字符最近一次出现的位置
	 */
	public static int maxUnique(String str) {
		if (str == null || str.equals("")) {
			return 0;
		}
		char[] chas = str.toCharArray();
		int[] map = new int[256];
		for (int i = 0; i < 256; i++) {
			map[i] = -1;
		}
		int len = 0;
		int pre = -1;
		int cur = 0;
		for (int i = 0; i != chas.length; i++) {
			pre = Math.max(pre, map[chas[i]]);
			cur = i - pre;
			len = Math.max(len, cur);
			map[chas[i]] = i;
		}
		return len;
	}
}