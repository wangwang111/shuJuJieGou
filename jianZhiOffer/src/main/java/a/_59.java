package a;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class _59 {

	/*
	 * 队列的最大值
	 * 
	 * 步骤
	 * 放入 1.如果qmax为空，直接把下标i放入qmax中 2.如果qmax不为空，取出当前qmax队尾放的下标j
	 * 如果arr[j]>arr[i]，直接把下标i放入qmax的队尾 3.如果arr[j]<=arr[i]，则一直从qmax的队尾弹出下标
	 * 直到某个下标在qmax中对应的值大于arr[i]，把i放入qmax的队尾
	 * 
	 * 弹出 如果qmax对头的下标等于i-w（过期），弹出qmax当前头下标
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
