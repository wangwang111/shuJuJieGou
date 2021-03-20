package a;

public class KMP_Manacher_bfprt {

	/*
		KMP算法
		
		next[]数组，与match相关
		next[]长度=match长度
		next[i]表示match中i位置前面 ，前缀等于后缀最长的长度
		
		例如：
		123123b
		      b位置next[6]=3
		前缀不能包含最后一个字符，后缀第一个字符
		
		next[]数组求解，
		0号位置默认为-1
		1号位置默认为1
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

	//求解next数组过程
	public static int[] getNextArray(char[] ms) {
		if (ms.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[ms.length];
		next[0] = -1;
		next[1] = 0;
		int pos = 2;								//相当于i位置
		int cn = 0;									//相当于跳的位置
		while (pos < next.length) {
			if (ms[pos - 1] == ms[cn]) {
				next[pos++] = ++cn;
			} else if (cn > 0) {
				cn = next[cn];						//cn往前跳
			} else {								//cn跳到-1位置
				next[pos++] = 0;					
			}
		}
		return next;
	}
	
	
	/*
	Manacher算法(求一个字符串中，最长回文子串)		时间复杂度:O(n)
	前面扩的字符对后面的字符没有影响，Manacher算法利用前面字符扩的结果

	普通方式，以某个字符作为中间向两边扩(奇数能扩，偶数不能扩，例：1221)    时间复杂度:O(n^2)
	Manacher算法:把每一个字符前后加一个特殊字符(可是任何字符)，每个字符之间加上一个特殊字符
		例如：1221    --》     #1#2#2#1#		
		奇回文同样适用，解决：虚轴问题
	则最长回文长度等于，原回文=总数/2  (向下取整)

	三个变量:(PR和index是配合使用)
		1.数组pArr[]:数组长度和处理后长度一样，数组值是最长回文半径长度
		2.整数PR:最长回文半径即将到达位置，即最长回文半径最右位置的下一个位置,初始时PR=0
		3.index:当PR更新的时候，那个回文中心位置
		PR和index配合使用
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
	 * bfprt算法
	 * 
	 * 简单做法，快排
	 * 时间复杂度O(nlong^2)
	 * 
	 * 给定一个无序的整型数组arr，找到其中最小的k个数	 时间复杂度O(n)	
	 *
	 * 1，将arr中的n个元素划分成n/5组，每组5个元素，如果最后的组不够5个元素，那么最后
	 *	 	剩下的元素为一组(n%5个元素)；
	 * 2.组内插入排序，组件不排序，中位数拿出来，组成数组arrM
	 * 3.求所有中位数的中位数，递归调用整个过程   --》 返回值：记为king，这个king作为划分元素
	 * 4.下面步骤和快排一样，king进行划分 
	 */
	
	
}
