package a;

import java.util.Stack;

public class _09 {

	/*
	 * ����ջʵ�ֶ���
	 * 
	 * 1. ��stact2��Ϊ��ʱ��stack2�е�ջ��Ԫ�������Ƚ�����е�Ԫ�أ����Ե���
	 * 2. ��stack2Ϊ��ʱ����stack1�е�Ԫ��ѹ��stack2ջ��
	 */
	
	public Stack<Integer> stackPush = new Stack<>();
	public Stack<Integer> stackPop = new Stack<>();

	public void add(int pushInt) {
		stackPush.push(pushInt);
	}

	public int poll() {
		if (stackPop.empty() && stackPush.empty()) {
			throw new RuntimeException("Queue is empty!");
		} else if (stackPop.empty()) {
			while (!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.pop();
	}

	/*public int peek() {
		if (stackPop.empty() && stackPush.empty()) {
			throw new RuntimeException("Queue is empty!");
		} else if (stackPop.empty()) {
			while (!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.peek();
	}*/

}
