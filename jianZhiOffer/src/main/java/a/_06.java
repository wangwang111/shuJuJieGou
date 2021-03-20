package a;

import java.util.Stack;

public class _06 {

	/*
	 * 从尾到头打印链表，后进先出
	 * 1.栈
	 * 2.递归
	 */
	
	//栈
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
	
	//递归
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
