package a;

public class KuoHao {

	/*
	 * 括号匹配
	 * 
	 * 1.整数status，代表‘(’出现次数的差值
	 * 2.遍历的过程中如果遇到‘(’，则status++
	 * 3.遍历的过程如果遇到‘)’,则status--
	 * 4.遍历过过程如果status<0,直接返回false
	 * 5.如果一直没有出现情况4，则一直遍历下去
	 * 6.遍历完成后，如果status==0，则返回true，否则返回false
	 */
	public static boolean isValid(String str) {
		if (str == null || str.equals("")) {
			return false;
		}
		char[] chas = str.toCharArray();
		int status = 0;
		for (int i = 0; i < chas.length; i++) {
			if (chas[i] != ')' && chas[i] != '(') {
				return false;
			}
			if (chas[i] == ')' && --status < 0) {
				return false;
			}
			if (chas[i] == '(') {
				status++;
			}
		}
		return status == 0;
	}

	/*
	 * 已知一个字符串都是由左括号(和右括号)组成，返回最长有效括号子串的长度。
	 */
	public static int maxLength(String str) {
		if (str == null || str.equals("")) {
			return 0;
		}
		char[] chas = str.toCharArray();
		int[] dp = new int[chas.length];
		int pre = 0;
		int res = 0;
		for (int i = 1; i < chas.length; i++) {
			if (chas[i] == ')') {
				pre = i - dp[i - 1] - 1;
				if (pre >= 0 && chas[pre] == '(') {
					dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}
}
