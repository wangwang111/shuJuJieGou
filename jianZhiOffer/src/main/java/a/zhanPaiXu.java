package a;

import java.util.Stack;

public class zhanPaiXu {

	/*
	 * 一个栈，从顶到底按从大到小排序，只许申请一个栈
	 */
	public static void sortStackByStack(Stack<Integer> stack) {
		Stack<Integer> help = new Stack<Integer>();
		while (!stack.isEmpty()) {
			int cur = stack.pop();
			while (!help.isEmpty() && help.peek() < cur) {
				stack.push(help.pop());
			}
			help.push(cur);
		}
		while (!help.isEmpty()) {
			stack.push(help.pop());
		}
	}

}
