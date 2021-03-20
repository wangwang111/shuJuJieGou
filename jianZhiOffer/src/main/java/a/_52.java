package a;

import java.util.HashMap;

public class _52 {

	/*
	 * ��������ĵ�һ�������ڵ� 
	 * 1.hash�� 
	 * 2.�ҳ������ȣ�Ȼ�󳤵���������ĳ��ȲȻ��һ����
	 */

	//1.hash��
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		ListNode current1 = pHead1;
		ListNode current2 = pHead2;

		HashMap<ListNode, Integer> map = new HashMap<>();

		while (current1 != null) {
			map.put(current1, null);
			current1 = current1.next;
		}
		while (current2 != null) {
			if (map.containsKey(current2))
				return current2;
			current2 = current2.next;
		}
		return null;
	}

	//2.�ҳ������ȣ�Ȼ�󳤵���������ĳ��ȲȻ��һ����
	public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
		int len1 = findListLenth(pHead1);
		int len2 = findListLenth(pHead2);

		if (len1 > len2) {
			pHead1 = walkStep(pHead1, len1 - len2);
		} else {
			pHead2 = walkStep(pHead2, len2 - len1);
		}
		while (pHead1 != null) {
			if (pHead1 == pHead2)
				return pHead1;
			pHead1 = pHead1.next;
			pHead2 = pHead2.next;
		}

		return null;

	}

	private int findListLenth(ListNode pHead1) {

		if(pHead1==null)
			return 0;
		int sum=1;
		while(pHead1==pHead1.next)
			sum++;
		
		return sum;
	}

	private ListNode walkStep(ListNode pHead1, int step) {
		
		while(step== 0){
			pHead1=pHead1.next;
			step--;
		}

		return pHead1;
	}

}
