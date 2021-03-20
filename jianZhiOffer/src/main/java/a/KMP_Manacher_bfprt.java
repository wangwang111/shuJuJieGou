package a;

public class KMP_Manacher_bfprt {

	/*
		KMP�㷨
		
		next[]���飬��match���
		next[]����=match����
		next[i]��ʾmatch��iλ��ǰ�� ��ǰ׺���ں�׺��ĳ���
		
		���磺
		123123b
		      bλ��next[6]=3
		ǰ׺���ܰ������һ���ַ�����׺��һ���ַ�
		
		next[]������⣬
		0��λ��Ĭ��Ϊ-1
		1��λ��Ĭ��Ϊ1
	*/
	
	public static int getIndexOf(String s, String m) {
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		int si = 0;
		int mi = 0;
		int[] next = getNextArray(ms);
		while (si < ss.length && mi < ms.length) {
			if (ss[si] == ms[mi]) {
				si++;
				mi++;
			} else if (next[mi] == -1) {
				si++;
			} else {
				mi = next[mi];
			}
		}
		return mi == ms.length ? si - mi : -1;
	}

	//���next�������
	public static int[] getNextArray(char[] ms) {
		if (ms.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[ms.length];
		next[0] = -1;
		next[1] = 0;
		int pos = 2;								//�൱��iλ��
		int cn = 0;									//�൱������λ��
		while (pos < next.length) {
			if (ms[pos - 1] == ms[cn]) {
				next[pos++] = ++cn;
			} else if (cn > 0) {
				cn = next[cn];						//cn��ǰ��
			} else {								//cn����-1λ��
				next[pos++] = 0;					
			}
		}
		return next;
	}
	
	
	/*
	Manacher�㷨(��һ���ַ����У�������Ӵ�)		ʱ�临�Ӷ�:O(n)
	ǰ�������ַ��Ժ�����ַ�û��Ӱ�죬Manacher�㷨����ǰ���ַ����Ľ��

	��ͨ��ʽ����ĳ���ַ���Ϊ�м���������(����������ż��������������1221)    ʱ�临�Ӷ�:O(n^2)
	Manacher�㷨:��ÿһ���ַ�ǰ���һ�������ַ�(�����κ��ַ�)��ÿ���ַ�֮�����һ�������ַ�
		���磺1221    --��     #1#2#2#1#		
		�����ͬ�����ã��������������
	������ĳ��ȵ��ڣ�ԭ����=����/2  (����ȡ��)

	��������:(PR��index�����ʹ��)
		1.����pArr[]:���鳤�Ⱥʹ���󳤶�һ��������ֵ������İ뾶����
		2.����PR:����İ뾶��������λ�ã�������İ뾶����λ�õ���һ��λ��,��ʼʱPR=0
		3.index:��PR���µ�ʱ���Ǹ���������λ��
		PR��index���ʹ��
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

	public static int maxLcpsLength(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] charArr = manacherString(str);
		int[] pArr = new int[charArr.length];
		int index = -1;
		int pR = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i != charArr.length; i++) {
			pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
				if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
					pArr[i]++;
				else {
					break;
				}
			}
			if (i + pArr[i] > pR) {
				pR = i + pArr[i];
				index = i;
			}
			max = Math.max(max, pArr[i]);
		}
		return max - 1;
	}
	
	
	
	/*
	 * bfprt�㷨
	 * 
	 * ������������
	 * ʱ�临�Ӷ�O(nlong^2)
	 * 
	 * ����һ���������������arr���ҵ�������С��k����	 ʱ�临�Ӷ�O(n)	
	 *
	 * 1����arr�е�n��Ԫ�ػ��ֳ�n/5�飬ÿ��5��Ԫ�أ���������鲻��5��Ԫ�أ���ô���
	 *	 	ʣ�µ�Ԫ��Ϊһ��(n%5��Ԫ��)��
	 * 2.���ڲ������������������λ���ó������������arrM
	 * 3.��������λ������λ�����ݹ������������   --�� ����ֵ����Ϊking�����king��Ϊ����Ԫ��
	 * 4.���沽��Ϳ���һ����king���л��� 
	 */
	
	
}
