package a;

import java.util.LinkedList;
import java.util.Queue;

/*
 * �����ӡ
 */
public class _32 {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int value) {
			this.value = value;
		}
	}

	/*
	 * last ���ڴ�ӡ��ǰ�е����ҽ�� 
	 * nlast ��һ�е����ҽ��
	 * 
	 * ÿһ�㶼�������ҵĿ�����ȱ�����������ֱ������Ľڵ����last��˵���û�����
	 * ����֮����last=nlast��������һ�д�ӡ,�ظ��˹��̣�ֱ�����н�㶼��ӡ��
	 * 
	 * �����ȷ����last��nlast��
	 * ��nlast�������¼���Ľڵ㼴��
	 */
	public static void printByLevel(Node head) {
		if (head == null) {
			return;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		int level = 1;
		Node last = head;
		Node nLast = null;
		queue.offer(head);
		System.out.print("Level " + (level++) + " : ");
		
		while (!queue.isEmpty()) {
			head = queue.poll();
			System.out.print(head.value + " ");
		
			if (head.left != null) {
				queue.offer(head.left);
				nLast = head.left;
			}
			if (head.right != null) {
				queue.offer(head.right);
				nLast = head.right;
			}
			if (head == last && !queue.isEmpty()) {
				System.out.print("\nLevel " + (level++) + " : ");
				last = nLast;
			}
		}
		System.out.println();
	}
}
