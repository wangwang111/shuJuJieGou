package a;

import java.util.Stack;

/*
 * 栈中最小元素
 */
public class _30 {

	private Stack<Integer> stackData = new Stack<Integer>();
	private Stack<Integer> stackMin = new Stack<Integer>();

	public void push(int newNum) {
		if (this.stackMin.isEmpty()) {
			this.stackMin.push(newNum);
		} else if (newNum <= this.getmin()) {
			this.stackMin.push(newNum);
		}
		this.stackData.push(newNum);
	}

	public int pop() {
		if (this.stackData.isEmpty()) {
			throw new RuntimeException("Your stack is empty.");
		}
		int value = this.stackData.pop();
		if (value == this.getmin()) {
			this.stackMin.pop();
		}
		return value;
	}

	public int getmin() {
		if (this.stackMin.isEmpty()) {
			throw new RuntimeException("Your stack is empty.");
		}
		return this.stackMin.peek();
	}
}
