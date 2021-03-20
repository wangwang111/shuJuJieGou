package a;

public class _58 {

	/*
	 * 翻转字符串
	 * 输入一个英文句子，翻转句子中单词的顺序，但单词顺序不变
	 * 
	 * 例如
	 * I am a student.   -->    student. a am I
	 * 
	 * 步骤1:翻转句子中所有的字符，比如翻转I am a student.中所有字符得到tneduts a ma I
	 * 步骤2:再翻转每个单词中字符的顺序，student. a am I
	 * 
	 * 
	 * 题目二
	 * 给定一个字符串，要求将字符冲前面若干个字符移动字符串的尾部
	 * 例如:abcdef的前3个字符'a','b'和'c'移到字符串的尾部,defabc
	 * 
	 * 三步反转
	 * 步骤1：将原字符分为X和Y两个部分，其中X为"abc"，Y为"def"
	 * 步骤2：将X的所有字符反转，即相当于反转"abc"得到"cba"，再将Y的所有字符也反转，相当于"def"得到"fed"
	 * 步骤3：最后，整体反转，即整体反转"cbafed"得到"defabc"
	 */
	
	public static void rotateWord(char[] chas) {
		if (chas == null || chas.length == 0) {
			return;
		}
		reverse(chas, 0, chas.length - 1);
		int l = -1;
		int r = -1;
		for (int i = 0; i < chas.length; i++) {
			if (chas[i] != ' ') {
				l = i == 0 || chas[i - 1] == ' ' ? i : l;
				r = i == chas.length - 1 || chas[i + 1] == ' ' ? i : r;
			}
			if (l != -1 && r != -1) {
				reverse(chas, l, r);
				l = -1;
				r = -1;
			}
		}
	}

	public static void reverse(char[] chas, int start, int end) {
		char tmp = 0;
		while (start < end) {
			tmp = chas[start];
			chas[start] = chas[end];
			chas[end] = tmp;
			start++;
			end--;
		}
	}


	//题目二
	void LeftRotateString(char[] s,int n,int m) {
		//若要左移动大于n位，那么与%n是等价的
		m%=n;
		reverse(s, 0, m-1);
		reverse(s, m, n-1);
		reverse(s, 0, n-1);
	}
	
	public static void main(String[] args) {
		char[] chas1 = { 'd', 'o', 'g', ' ', 'l', 'o', 'v', 'e', 's', ' ', 'p',
				'i', 'g' };
		System.out.println(String.valueOf(chas1));
		rotateWord(chas1);
		System.out.println(String.valueOf(chas1));

	}

}
