package lianbiao;




public class FanZhuan {
	
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
			pReverseHead=pNode;
			pNode=pNext;
		}
		return pReverseHead;
	}

}