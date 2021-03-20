package a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class _38 {

	/*
	 * �ַ�������
	 * 
	 * ��һ���ַ���������������ɣ���һ�����������ĵ�һ���ַ����ڶ������Ǻ���������ַ�
	 * ��һ�������п��ܳ����ڵ�һ��λ�õ��ַ������ѵ�һ���ַ��ͺ���������ַ�����
	 * �ڶ������̶���һ���ַ�������������ַ�������
	 * Ȼ���԰��ַ����������֣��ݹ�
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
			swap(str, i, k);				//��i==beginʱ��ҲҪ���������������ַ���
											//��i!=beginʱ���Ƚ�����ʹ��beginλȡ����ͬ�Ŀ����ַ����ٱ���������ַ�
			Permutation(set, str, k + 1);
	
			swap(str, i, k);				//Ϊ�˷�ֹ�ظ������������Ҫ��begin����Ԫ�����»�����
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
