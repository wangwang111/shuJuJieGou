package erchashu;

import java.util.Stack;

public class BianLi {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	//递归的方式先序遍历
	public static void preOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}

	//递归的方式中序遍历
	public static void inOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.print(head.value + " ");
		inOrderRecur(head.right);
	}

	//递归的方式后续遍历
	public static void posOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.print(head.value + " ");
	}

	/*
	 * 非递归先序
	 * 
	 * 1.先申请一个栈，记为stack
	 * 2.将头结点head压入stack中
	 * 3. 每次从stack中弹出栈顶结点，记为cur，然后打印cur结点的值。
	 * 		如果cur右孩子不为空的话，将cur的右孩子先压入stack。
	 * 		最后如果cur的左孩子不为空的话，将cur的左孩子压入stack中
	 * 4.不断重复步骤3，直到stack为空，全部过程结束
	 */
	public static void preOrderUnRecur(Node head) {
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.push(head);
			while (!stack.isEmpty()) {
				head = stack.pop();
				System.out.print(head.value + " ");
				if (head.right != null) {
					stack.push(head.right);
				}
				if (head.left != null) {
					stack.push(head.left);
				}
			}
		}
	}

	/*	
	 * 非递归实现中序遍历
	 * 1.申请一个stack，申请一个变量cur，初始化cur等于头结点
	 * 2.先把cur节点压入栈中，对以cur节点为头结点的整颗子树来说，依次把整颗树的左边界压入栈中
	 * 		即不断令cur=cur.left，然后重复步骤2
	 * 3.不断重复步骤2，直到发现cur为空，此时从stack中弹出一个节点，记为node。
	 * 		打印node值，并让cur=node.right，然后重复步骤2
	 * 4.当stack为空并且cur为空时， 整个过程结束
	 */
	public static void inOrderUnRecur(Node head) {
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			while (!stack.isEmpty() || head != null) {
				if (head != null) {
					stack.push(head);
					head = head.left;
				} else {
					head = stack.pop();
					System.out.print(head.value + " ");
					head = head.right;
				}
			}
		}
	}	

	/*
	 * 非递归后序遍历
	 * 
	 * 方法一
	 * 使用两个栈实现
	 * 1. 申请一个栈s1，然后头结点压入s1中
	 * 2. 从s1中弹出结点cur，然后cur的左孩子压入s1中，然后cur右孩子压入s1中
	 * 3. 在整个过程中，从s1中弹出的节点都放入第二个栈s2中
	 * 4. 不断重复步骤2和步骤3，直到s1为空，过程停止
	 * 5. 从s2中依次弹出结点并打印，打印的顺序就是后序遍历的顺序 
	 */
	public static void posOrderUnRecur1(Node head) {
		if (head != null) {
			Stack<Node> s1 = new Stack<Node>();
			Stack<Node> s2 = new Stack<Node>();
			s1.push(head);
			while (!s1.isEmpty()) {
				head = s1.pop();
				s2.push(head);
				if (head.left != null) {
					s1.push(head.left);
				}
				if (head.right != null) {
					s1.push(head.right);
				}
			}
			while (!s2.isEmpty()) {
				System.out.print(s2.pop().value + " ");
			}
		}
	}

}
