package a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class _38 {

	/*
	 * 字符串排序
	 * 
	 * 把一个字符看成由两部分组成，第一个部分是它的第一个字符，第二部分是后面的所有字符
	 * 第一步：所有可能出现在第一个位置的字符，即把第一个字符和后面的所有字符交换
	 * 第二步：固定第一个字符，求后面所有字符的排序
	 * 然后，仍把字符看成两部分，递归
	 */
	ArrayList<String> Permutation(String str) {
		ArrayList<String> re = new ArrayList<>();
		if (str == null || str.length() == 0)
			return re;
		HashSet<String> set = new HashSet<>();
		Permutation(set, str.toCharArray(), 0);
		re.addAll(set);
		Collections.sort(re);
		return re;
	}

	private void Permutation(HashSet<String> set, char[] str, int k) {
		if (k == str.length) {
			set.add(new String(str));
			return;
		}

		for (int i = k; i < str.length; i++) {
			swap(str, i, k);				//当i==begin时，也要遍历其后面的所有字符；
											//当i!=begin时，先交换，使第begin位取到不同的可能字符，再遍历后面的字符
			Permutation(set, str, k + 1);
	
			swap(str, i, k);				//为了防止重复的情况，还需要将begin处的元素重新换回来
		}
	}

	private void swap(char[] str, int i, int j) {
		if (i != j) {
			char t = str[i];
			str[i] = str[j];
			str[j] = t;
		}
	}

	public static void main(String[] args) {
		ArrayList arr=new _38().Permutation("abced");
		System.out.println(arr);
	}
}
