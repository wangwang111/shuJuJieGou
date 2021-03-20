package a;

public class InsertYouXuHuan {

	/*
	 * �������в���Ԫ��
	 * 1.�������Ϊ�գ��������Լ�ʵ�ֻ�������
	 * 2.����Ϊ�գ�preָ��head��㣬curָ����һ���ڵ�
	 * 		Ȼ��ͬ���ƶ����������p.val<node.val<c.val,�����p��c֮��
	 * 3.���p��cתһȦ��û�з���Ӧ�ò����λ�ã���ʱӦ�ò���ͷ����ǰ��
	 */
	
	public static Node insertNum(Node head, int num) {
		Node node = new Node(num);
		if (head == null) {
			node.next = node;
			return node;
		}
		
		Node pre = head;
		Node cur = head.next;
		while (cur != head) {
			if (pre.value <= num && num <= cur.value ) {
				break;
			}
			pre = cur;
			cur = cur.next;
		}
		pre.next = node;
		node.next = cur;
		return head.value < num ? head : node;
	}


	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

}
