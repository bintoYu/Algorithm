/**
 * 
 */
package 高质量代码;

import 数据结构.ListNode;

//已通过
public class 删除链表中重复的节点
{
	public ListNode deleteDuplicateNode(ListNode pHead)
	{
		if(pHead == null) return pHead;
		
		ListNode preNode = null;
		ListNode pNode = pHead;
		
		while(pNode!=null)
		{
			//出现重复，注意pNode.next可能为null
			if(pNode.next != null && pNode.val == pNode.next.val)
			{
				//不断前进到最后一个重复的点
				while(pNode.next!=null && pNode.val == pNode.next.val)
					pNode = pNode.next;
				
				//移除重复的点，并前进
				//考虑头就重复的情况
				if(preNode == null)
				{
					pHead = pNode.next;
					pNode = pHead;
				}
				else
				{
					//其余情况
					pNode = pNode.next;
					preNode.next = pNode;
				}
			}
			else
			{
				//没有重复的时候，都前进一格即可
				preNode = pNode;
				pNode = pNode.next;
			}
		}
		
		return pHead;
	}
	
	
	public static void main(String[] args)
	{
		ListNode listNode = new ListNode(3);
		listNode.next = new ListNode(3);
		listNode.next.next = new ListNode(3);
		listNode.next.next.next = new ListNode(3);
		listNode.next.next.next.next = new ListNode(4);
		
		ListNode head = new 删除链表中重复的节点().deleteDuplicateNode(listNode);
		
		while(head != null)
		{
			System.out.println(head.val + "\t");
			head = head.next;
		}
	}
}
