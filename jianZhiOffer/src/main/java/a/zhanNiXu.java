package a;

import java.util.Stack;

public class zhanNiXu {

	/*
	 * 实现一个栈的逆序，但只能用递归函数和栈本身实现
	 */

	// 移除栈底元素并返回
	public int get(Stack<Integer> stack) {
		int result = stack.pop();
		if (stack.isEmpty()) {
			return result;
		} else {
			int last = get(stack);
			stack.push(result);
			return last;
		}
	}
	
	public void reverse(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		int i=get(stack);
		reverse(stack);
		stack.push(i);
	}
}
