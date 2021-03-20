package zifuchuan;

public class KuoHao {

	/*
	 * ����ƥ��
	 * 
	 * 1.����status������(�����ִ����Ĳ�ֵ
	 * 2.�����Ĺ��������������(������status++
	 * 3.�����Ĺ������������)��,��status--
	 * 4.�������������status<0,ֱ�ӷ���false
	 * 5.���һֱû�г������4����һֱ������ȥ
	 * 6.������ɺ����status==0���򷵻�true�����򷵻�false
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
	 * ��֪һ���ַ���������������(��������)��ɣ��������Ч�����Ӵ��ĳ��ȡ�
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
