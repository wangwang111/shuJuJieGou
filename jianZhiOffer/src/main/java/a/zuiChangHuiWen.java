package a;

public class zuiChangHuiWen {

	/*
	 * ������Ӵ�
	 * 
	 * 1.������չ�� 
	 * 2.Manacher�㷨
	 */
	public static char[] manacherString(String str) {
		char[] charArr = str.toCharArray();
		char[] res = new char[str.length() * 2 + 1];
		int index = 0;
		for (int i = 0; i != res.length; i++) {
			res[i] = (i & 1) == 0 ? '#' : charArr[index++];
		}
		return res;
	}
	
	static int LongestPalindrome(char[] s) {

		int i, j, max = 0, c = 0;
		if (s == null || s.length < 1) {
			return 0;
		}

		char[] charArr = manacherString(new String(s));
		int[] pArr = new int[charArr.length];
		
		// iΪ��������λ��
		for (i = 0; i < pArr.length; i++) {

			for (j = 0; (i - j >= 0) && (i + j < pArr.length); j++) {
				if (s[i - j] != s[i + j]) {
					break;
				}
				c = j * 2 + 1;
			}
			if (c > max) {
				max = c;
			}

		}
		return max/2;
	}
}
