package erchashu;

import java.util.Stack;

public class Demo1 {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static void prOrderRecur(Node node) {
	
		if(node==null)
			return;
		
		System.out.println(node.value);
		prOrderRecur(node.left);
		prOrderRecur(node.right);
	}
	
	public static void preOrderUnRecur(Node head) {
		if(head!=null) {
			Stack<Node> stack=new Stack<Node>();
			stack.add(head);
			while(!stack.isEmpty()) {
				head=stack.pop();
				System.out.println(head.value);
				if(head.right!=null)
					stack.push(head.right);
				if(head.left!=null) {
					stack.push(head.left);
				}
			}
		}
	}
	
	public static void inOrderRecur(Node head) {
		if(head==null)
			return;
		inOrderRecur(head.left);
		System.out.println(head.value);
		inOrderRecur(head.right);
	}
	
	
	public static void inOrderUnRecur(Node head) {
		if(head!=null) {
			Stack<Node> stack=new Stack<Node>();
			while(stack.isEmpty() || head!=null) {
				if(head!=null) {
					stack.push(head);
					head=head.left;
				}else {
					head=stack.pop();
					System.out.println(head.value);
					head=head.right;
				}
			}
		}
	}
	
	
	public static void posOrderRecur(Node head) {
		if(head==null)
			return;
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.println(head.value);
	}
	
	public static void posOrderUnRecur(Node heada) {
		
	}
}
