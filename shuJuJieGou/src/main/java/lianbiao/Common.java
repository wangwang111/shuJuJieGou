package lianbiao;

import java.util.ArrayList;

public class Common {

    public ArrayList<Integer> findCommonParts(ListNode headA, ListNode headB) 
	{
        ArrayList<Integer> res = null;
		ListNode p=headA,q=headB;
		while(p!=null && q!=null)
		{
			if(p.value==q.value)
			{
				res.add(p.value);
				p=p.next;
				q=q.next;
			}
			else if(p.value<q.value)
				p=p.next;
			else
				q=q.next;
		}
		return res;
    }

}
