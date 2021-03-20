package a;

public class _24 {

	/*
	 * 翻转链表
	 * 
	 *  head->now
	 *  1.将now结点指针指向head，
	 *  2.将now结点，设为新的头部head=now
	 *  3.步骤一之前提前now的下一结点记下来，然后将now结点指向纪录下来的节点
	 *  最后返回当前head结点
	 */
	
	public ListNode ReverseList(ListNode pHead) {
		
		if(pHead==null)
			return null;					//注意程序鲁棒性
		ListNode pNode=pHead;				//当前指针
		ListNode pReverseHead=null;			//新链表的头指针
		ListNode pPrev=null;				//当前指针的前一个结点
		
		while(pNode!=null) {				//当前结点不为空时才执行
			ListNode pNext=pNode.next;
			
			if(pNext==null)					//当pNext为空时，说明当前结点为尾节点
				pReverseHead=pNode;
			
			pNode.next=pPrev;
			pPrev=pNode;
			pNode=pNext;
		}
		return pReverseHead;
	}

}