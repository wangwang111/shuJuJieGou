package a;

public class _24 {

	/*
	 * ��ת����
	 * 
	 *  head->now
	 *  1.��now���ָ��ָ��head��
	 *  2.��now��㣬��Ϊ�µ�ͷ��head=now
	 *  3.����һ֮ǰ��ǰnow����һ����������Ȼ��now���ָ���¼�����Ľڵ�
	 *  ��󷵻ص�ǰhead���
	 */
	
	public ListNode ReverseList(ListNode pHead) {
		
		if(pHead==null)
			return null;					//ע�����³����
		ListNode pNode=pHead;				//��ǰָ��
		ListNode pReverseHead=null;			//�������ͷָ��
		ListNode pPrev=null;				//��ǰָ���ǰһ�����
		
		while(pNode!=null) {				//��ǰ��㲻Ϊ��ʱ��ִ��
			ListNode pNext=pNode.next;
			
			if(pNext==null)					//��pNextΪ��ʱ��˵����ǰ���Ϊβ�ڵ�
				pReverseHead=pNode;
			
			pNode.next=pPrev;
			pPrev=pNode;
			pNode=pNext;
		}
		return pReverseHead;
	}

}