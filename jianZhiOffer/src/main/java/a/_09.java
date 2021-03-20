package a;

import java.util.Stack;

public class _09 {

	/*
	 * 两个栈实现队列
	 * 
	 * 1. 当stact2不为空时，stack2中的栈顶元素是最先进入队列的元素，可以弹出
	 * 2. 当stack2为空时，把stack1中的元素压入stack2栈中
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
