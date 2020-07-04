package 高质量代码;

import 数据结构.ListNode;

public class 删除链表的节点
{
	public ListNode deleteNode(ListNode head,ListNode toBeDeletedNode)
	{
		if(head == null || toBeDeletedNode == null)
			return head;
		
		//头和只有一个
		if(toBeDeletedNode == head)
		{
			head = head.next;
			return head;
		}
		//中间
		else if(toBeDeletedNode.next != null)
		{
			toBeDeletedNode.val = toBeDeletedNode.next.val;
			toBeDeletedNode.next = toBeDeletedNode.next.next;
			return head;
		}
		//尾
		else if(toBeDeletedNode != head)
		{
			ListNode pNode = head;
			while(pNode.next != toBeDeletedNode)
				pNode = pNode.next;
			pNode.next = null;
			return head;
		}	
		
		return null;
	}
}
