package linkedlist;

/**
 * @author Administrator
 *
 * @date 2018年11月1日  
 * @version 1.0  
 */
public class Intersection_of_Two_Linked_Lists_160
{
	/**
	 * 算法：找到两条路径相同长度的起始点。
	 * 步骤：1、同时前进，直到一个到底；另一个没走完的长度 = 两者的长度差。
	 * 2、接着长的路径的头指针和未走完的指针同时前进。
	 * 3、当后面的走完时，前面的指针便刚好到达起始点。
	 */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if(headA == null || headB == null)
    		return null;
    	
    	ListNode pNode = headA;
    	ListNode qNode = headB;
    	
    	//同时前进，直到一个到底。
    	while(pNode != null && qNode != null)
    	{
    		pNode = pNode.next;
    		qNode = qNode.next;
    	}
    	
    	//接着长的路径的头指针和未走完的指针同时前进
    	if(pNode == null)
    	{
    		while(qNode != null)
    		{
    			headB = headB.next;
    			qNode = qNode.next;
    		}
    	}
    	else if(qNode == null)
    	{
    		while(pNode != null)
    		{
    			headA = headA.next;
    			pNode = pNode.next;
    		}
    	}
    	
    	while(headA != null && headB != null)
    	{
    		if(headA.equals(headB))
    			return headA;
    		headA = headA.next;
    		headB = headB.next;
    	}
    	
    	return null;
    }
}
