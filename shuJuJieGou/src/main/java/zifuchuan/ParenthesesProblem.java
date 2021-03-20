package zifuchuan;

public class ParenthesesProblem {

	/*
	 * 1.整数变量num，代表“(”出现次数与")"出现次数的差值
	 * 2.遍历的过程中如果遇到"("，则num++
	 * 3.遇到")",则num--
	 * 4.遍历的过程如果num<0，则直接返回false
	 * 5.如果未出现4，一直遍历下去
	 * 6.遍历完成后，如果num==0，则返回true，否则false
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


}
