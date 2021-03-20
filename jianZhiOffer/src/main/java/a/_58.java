package a;

public class _58 {

	/*
	 * ��ת�ַ���
	 * ����һ��Ӣ�ľ��ӣ���ת�����е��ʵ�˳�򣬵�����˳�򲻱�
	 * 
	 * ����
	 * I am a student.   -->    student. a am I
	 * 
	 * ����1:��ת���������е��ַ������緭תI am a student.�������ַ��õ�tneduts a ma I
	 * ����2:�ٷ�תÿ���������ַ���˳��student. a am I
	 * 
	 * 
	 * ��Ŀ��
	 * ����һ���ַ�����Ҫ���ַ���ǰ�����ɸ��ַ��ƶ��ַ�����β��
	 * ����:abcdef��ǰ3���ַ�'a','b'��'c'�Ƶ��ַ�����β��,defabc
	 * 
	 * ������ת
	 * ����1����ԭ�ַ���ΪX��Y�������֣�����XΪ"abc"��YΪ"def"
	 * ����2����X�������ַ���ת�����൱�ڷ�ת"abc"�õ�"cba"���ٽ�Y�������ַ�Ҳ��ת���൱��"def"�õ�"fed"
	 * ����3��������巴ת�������巴ת"cbafed"�õ�"defabc"
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


	//��Ŀ��
	void LeftRotateString(char[] s,int n,int m) {
		//��Ҫ���ƶ�����nλ����ô��%n�ǵȼ۵�
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
