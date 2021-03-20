package lianbiao;
/*
 面试题18（一）：在O(1)时间删除链表结点
 题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该
 */
public class Remove {

	public void DeleteNode(ListNode pListHead, ListNode pToBeDeleted)
	{
	    if(pListHead!=null || pToBeDeleted!=null)
	        return;

	    // 要删除的结点不是尾结点
	    if(pToBeDeleted.next != null)
	    {
	        ListNode pNext = pToBeDeleted.next;
	        pToBeDeleted.value = pNext.value;
	        pToBeDeleted.next = pNext.next;
	 
	        pNext = null;
	    }
	    // 链表只有一个结点，删除头结点（也是尾结点）
	    else if(pListHead == pToBeDeleted)
	    {
	        pListHead = null;
	    }
	    // 链表中有多个结点，删除尾结点
	    else
	    {
	        ListNode pNode = pListHead;
	        while(pNode.next != pToBeDeleted)
	        {
	            pNode = pNode.next;            
	        }
	 
	        pNode.next = null;
	    }
	}

}
