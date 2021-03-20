package a;

import java.util.Stack;

public class _31 {
	
	/*
	 * ջ��ѹ�롢��������
	 * �����������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ�������
	 * 
	 * �����һ�����������ָպ���ջ��Ԫ�أ���ôֱ�ӵ�����
	 * �����һ�����������ֲ���ջ�������ѹ�������л�û����ջ��Ԫ���븨��ջ
	 * ����������ֶ�ѹ��ջ����Ȼû���ҵ���һ�����������飬��ô�����в�������һ����������
	 */
	public boolean IsPopOrder(int[] pushA, int[] popA) {
		if (pushA.length == 0 || popA.length == 0)
			return false;
		
		Stack<Integer> s = new Stack<Integer>();
		int popIndex = 0;
		
		for (int i = 0; i < pushA.length; i++) {
			s.push(pushA[i]);
			// ���ջ��Ϊ�գ���ջ��Ԫ�ص��ڵ�������
			while (!s.empty() && s.peek() == popA[popIndex]) {
				// ��ջ
				s.pop();
				// �����������һλ
				popIndex++;
			}
		}
		return s.empty();
	}
}
