package a;

import java.util.Stack;

public class _06 {

	/*
	 * ��β��ͷ��ӡ��������ȳ�
	 * 1.ջ
	 * 2.�ݹ�
	 */
	
	//ջ
	static void printListReverse(ListNode pHead) {
		
		Stack<ListNode> nodes=new Stack<ListNode>();
		
		ListNode pNode=pHead;
		while(pNode!=null) {
			nodes.push(pNode);
			pNode=pNode.next;
		}
		
		while(!nodes.isEmpty()) {
			pNode=nodes.pop();
			System.out.print(pNode.value+" ");
		}
	}
	
	//�ݹ�
	static void printListReverse2(ListNode pHead) {
		if(pHead!=null) {
			if(pHead.next!=null) {
				printListReverse2(pHead.next);
			}
		}
		System.out.print(pHead.value+" ");
	}
	
	public static void main(String[] args) {
		ListNode nodes1=new ListNode(1);
		ListNode nodes2=new ListNode(2);
		ListNode nodes3=new ListNode(3);
		nodes1.next=nodes2;
		nodes2.next=nodes3;
		printListReverse2(nodes1);
	}
}
