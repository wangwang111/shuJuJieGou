package a;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class _59 {

	/*
	 * ���е����ֵ
	 * 
	 * ����
	 * ���� 1.���qmaxΪ�գ�ֱ�Ӱ��±�i����qmax�� 2.���qmax��Ϊ�գ�ȡ����ǰqmax��β�ŵ��±�j
	 * ���arr[j]>arr[i]��ֱ�Ӱ��±�i����qmax�Ķ�β 3.���arr[j]<=arr[i]����һֱ��qmax�Ķ�β�����±�
	 * ֱ��ĳ���±���qmax�ж�Ӧ��ֵ����arr[i]����i����qmax�Ķ�β
	 * 
	 * ���� ���qmax��ͷ���±����i-w�����ڣ�������qmax��ǰͷ�±�
	 */
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> res = new ArrayList<>();
		if (size == 0)
			return res;
		int begin;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < num.length; i++) {
			begin = i - size + 1;
			if (q.isEmpty())
				q.add(i);
			else if (begin > q.peekFirst()) {
				q.pollFirst();
			}

			while (!q.isEmpty() && num[q.peekLast()] <= num[i])
				q.pollLast();
			q.add(i);
			if (begin >= 0)
				res.add(num[q.peekFirst()]);
		}
		return res;
	}

}
