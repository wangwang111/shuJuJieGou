package a;

import java.util.Stack;

public class zhanNiXu {

	/*
	 * ʵ��һ��ջ�����򣬵�ֻ���õݹ麯����ջ����ʵ��
	 */

	// �Ƴ�ջ��Ԫ�ز�����
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
