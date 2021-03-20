package a;

import java.util.Stack;

public class _31 {
	
	/*
	 * 栈的压入、弹出序列
	 * 输入两个序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出序列
	 * 
	 * 如果下一个弹出的数字刚好是栈顶元素，那么直接弹出；
	 * 如果下一个弹出的数字不在栈顶，则把压入序列中还没有入栈的元素入辅助栈
	 * 如果所有数字都压入栈后仍然没有找到下一个弹出的数组，那么该序列不可能是一个弹出序列
	 */
	public boolean IsPopOrder(int[] pushA, int[] popA) {
		if (pushA.length == 0 || popA.length == 0)
			return false;
		
		Stack<Integer> s = new Stack<Integer>();
		int popIndex = 0;
		
		for (int i = 0; i < pushA.length; i++) {
			s.push(pushA[i]);
			// 如果栈不为空，且栈顶元素等于弹出序列
			while (!s.empty() && s.peek() == popA[popIndex]) {
				// 出栈
				s.pop();
				// 弹出序列向后一位
				popIndex++;
			}
		}
		return s.empty();
	}
}
