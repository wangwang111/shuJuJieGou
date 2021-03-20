package a;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 按层打印
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
	 * last 正在打印当前行的最右结点 
	 * nlast 下一行的最右结点
	 * 
	 * 每一层都做从左到右的宽度优先遍历，如果发现遍历到的节点等于last，说明该换行了
	 * 换行之后令last=nlast，继续下一行打印,重复此过程，直到所有结点都打印完
	 * 
	 * 如何正确更新last和nlast？
	 * 让nlast更新最新加入的节点即可
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
